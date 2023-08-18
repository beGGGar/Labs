using System;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using System.Text;
using System.Xml.Linq;
using System.ComponentModel;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using System.Runtime.Serialization;
using System.Data;

namespace Lab
{
    [Serializable]
    class Student: Person, IDateAndCopy, INotifyPropertyChanged
    {
        #region fields
        private Enums education;
        private int group;
        private List<Test> tests;
        private List<Exam> exams;
        public event PropertyChangedEventHandler PropertyChanged;
        #endregion
        #region properties
        public Person StudName
        {
            get { return new Person(name, fname, birthday); }
            set { name = value.Name;
                fname = value.Fname;
                birthday = value.Birthday;
            }
        }
        public Enums Education { 
            get { return education; } 
            set { education = value;
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs($"Education changed to {education}"));
            } }
        public int Group
        {
            set { try
                {
                    if (value <= 100 || value > 600) throw new ArgumentOutOfRangeException("\nНеподобающее значение. (Группы: 100 < № <600");
                    else group = value;
                }
                catch(ArgumentOutOfRangeException e)
                {
                    Console.WriteLine(e.ToString());
                }
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs($"Group changed to {group}"));
            }
            get { return group; }
        }
        public List<Exam> Exams { 
            get { return exams; } 
            set {
                if (value.Count > 0)
                {
                    exams.Clear();
                    for (int i = 0; i < value.Count; i++)
                    {
                        exams[i] = value[i];
                    }
                }
            }  }
        public List<Test> Tests { 
            get { return tests; } 
            set {
                if (value.Count > 0)
                {
                    tests.Clear();
                    for (int i = 0; i < value.Count; i++)
                    {
                        tests[i] = value[i];
                    }
                }
            } }
        public double GetMidleMark
        {
            get
            {
                double summ = 0;
                int k = exams.Count;
                if(k == 0)
                {
                    return 0;
                }
                for (int i = 0; i < k; i++)
                {
                    summ = summ + ((Exam)exams[i]).Mark; 
                }
                return summ / k;
            }
        }
        #endregion
        #region constructors
        public Student(Person P, Enums E, int group_) : base(P.Name, P.Fname, P.Birthday)
        {
            education = E;
            group = group_;
            tests = new List<Test>();
            exams = new List<Exam>();
        }
        public Student() : this(new Person(), Enums.NotStated, -1)
        { }
        public bool this[Enums e]
        {
            get
            {
                return education == e;
            }
        }
        #endregion
        #region methods
        public void AddExams(params Exam[] exam)
        {
            for (int i=0; i<exam.Length; i++)
            {
                exams.Add(exam[i]);
            }
        }
        public override string ToString()
        {
            string buff = "";
            //int k;
            if (tests != null)
            {
                buff = buff + "\nTests:";
                foreach(var test in tests)
                {
                    buff = buff + "\n" + test.ToString();
                }
            }
            if (exams != null)
            {
                buff = buff + "\nPassed exams: ";
                foreach(var exam in exams)
                {
                    buff = buff + "\n" + exam.ToString();
                }
            }
            return "Name: " + name + "\nEducation: " + education + "\nGroup: " + group + buff + "\n";
        }
        public override string ToShortString()
        {
            return "Name: "+ name + "\nEducation: " + education + "\nGroup: " + group + "\nMidle mark: " + GetMidleMark+ "\n";
        }
        public override bool Equals(object obj)
        {
            if (obj == null)
            {
                return false;
            }
            bool itEquals = true;
            Student student = (Student)obj;
            for (int i = 0; i<tests.Count && itEquals ; i++)
            {
                itEquals = itEquals && tests[i].Equals(student.Tests[i]);
            }
            for (int i = 0; i < exams.Count && itEquals; i++)
            {
                itEquals = itEquals && exams[i].Equals(student.exams[i]);
            }
            return
                new Person(Name, Fname, Birthday).Equals(new Person(student.Name, student.Fname, student.Birthday)) &&
                education == student.Education &&
                group == student.Group &&
                itEquals;
        }
        public override int GetHashCode()
        {
            unchecked
            {
                int hash = 17;
                hash = hash * 23 + name.GetHashCode();
                hash = hash * 23 + education.GetHashCode();
                hash = hash * 23 + group.GetHashCode();
                hash = hash * 23 + exams.GetHashCode();
                return hash;
            }
        }
        public static bool operator ==(Student one, Student two)
        {
            return one.Equals(two);

        }
        public static bool operator !=(Student one, Student two)
        {
            return !one.Equals(two);
        }
        //public object DeepCopy()
        //{
        //    Person person = new Person(Name, Fname, Birthday); 
        //    Student student = new Student(person, education, group);
        //    student.Exams = exams;
        //    student.Tests = tests;
        //    return student;
        //}
        public void SortExamToName()
        {
            exams.Sort();
        }
        public void SortExamToMark()
        {
            Exam exam = new Exam();
            exams.Sort(exam);
        }
        public void SortExamToDate()
        {
            ComparerExam DateComperer = new ComparerExam();
            exams.Sort(DateComperer);
        }
        //lab 5
        public Student DeepCopyForSer() { //public new
            MemoryStream stream= new MemoryStream();
            try
            {
                BinaryFormatter formatter = new BinaryFormatter();
                formatter.Serialize(stream, this);
                stream.Position = 0;
                return formatter.Deserialize(stream) as Student;
            }
            catch
            {
                Console.WriteLine("\nError during DeepCopy making.\n");
                return new Student();
            }
            finally { stream.Close(); }
        }
        public bool Save(string filename) {
            Stream file = null;
            try
            {
                if (File.Exists(filename)) file = File.Open(filename, FileMode.Append);
                else file = File.Create(filename);
                BinaryFormatter formatter = new BinaryFormatter();
                formatter.Serialize(file, this);
                file.Close();
                return true;
            }
            catch
            {
                Console.WriteLine("\nError during SAVE");
                file?.Close();
                return false;
            }
        }
        public bool Load(string filename) {
            Stream file = null;
            if (File.Exists(filename))
            {
                try
                {
                    file = File.OpenRead(filename);
                    BinaryFormatter formatter = new BinaryFormatter();
                    Student newStud = new Student();
                    newStud = formatter.Deserialize(file) as Student;
                    if (!CopyToThis(newStud)) throw new Exception();
                    file.Close();
                    return true;
                }
                catch
                {
                    Console.WriteLine("\nError during LOAD in file" + filename);
                    file?.Close();
                    return false;
                }
            }
            else
            {
                //File.Create(filename).Close();//создание файла при его отсутствии(по заданию) // переместить в main
                Console.WriteLine("\nNo file "+ filename + " in dir");
                return false;
            }
        }
        private bool CopyToThis(Student other)//копирование другого obj в этот
        {
            if (other == null) return false;
            this.Group= other.group;
            this.Education= other.Education;
            this.Tests = other.Tests;
            this.Group = other.Group;
            return true;
        }
        public bool AddFromConsole() 
        {
            Console.WriteLine("Введите данные student в одну строку в формате:\n НазваниеПредмета;оценка(int 0<=n<=100);датаСдачи(дд.мм.гггг)\n");
            try
            {
                String[] arg = Console.ReadLine().Split(';', '!', '@', '#', ',', '$', '&', '/');
                if (arg.Length <= 3)
                {
                    Exam obj = new Exam();
                    obj.Name = arg[0];
                    obj.Mark = Convert.ToInt32(arg[1]);
                    obj.Date = Convert.ToDateTime(arg[2]);
                    exams.Add(obj);
                    return true;
                }
                else { Console.WriteLine("Wrong arguments count"); return false; }  
            }
            catch { 
                Console.WriteLine("S-th wrong in input arguments!\n");
                return false;
            }
        }
        public static bool Save(string filename, Student obj)
        {   
            return obj.Save(filename);
        }
        public static bool Load(string filename, Student obj) 
        {
            return obj.Load(filename); 
        }

        #endregion
        #region interfaces

        public IEnumerator<Object> GetEnumerator()
        {
            for  (int i = 0; i < exams.Count; i++)
            {
                if (exams[i] != null)
                {
                    yield return exams[i];
                }
                
            }
            for (int i = 0; i < tests.Count; i++)
            {
                if (tests[i] != null)
                {
                    yield return tests[i];
                }

            }
            
        }
        public IEnumerable<Exam> PassedExams(int min_mark)
        {
            
            if (exams != null)
            {
                for (int i = 0; i < exams.Count; i++)
                {
                    if ((exams[i]).Mark > min_mark)
                    {
                        yield return exams[i];
                    }
                }
            }
            
        }
        #endregion

    }
}
