using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using System.Xml.Linq;

namespace lab_2
{
    class Student: Person, IDateAndCopy
    {
        private Education education;
        private int group;
        private System.Collections.ArrayList tests;
        private System.Collections.ArrayList exams;
        public Student(Person P, Education E, int group_): base(P.Name, P.Fname, P.Birthday)
        {
            education = E;
            group = group_;
        }
        public Student() : this(new Person(), Education.Bachelor, 0)
        { }
        public Person StudName
        {
            get { return new Person(name, fname, birthday); }
            set { name = value.Name;
                fname = value.Fname;
                birthday = value.Birthday;
            }
        }
        public Education Education { get; set; }
        public int Group
        {
            set { try
                {
                    if (value <= 100 || value > 599) throw new ArgumentOutOfRangeException("Неподобающее значение. (Группы: 100 < № <600");
                    else group = value;
                }
                catch(ArgumentOutOfRangeException e)
                {
                    Console.WriteLine(e.ToString());
                }
                }
            get { return group; }
        }
        public System.Collections.ArrayList Exams { get { return exams; } set { exams = value; }  }
        public System.Collections.ArrayList Tests { get { return tests; } set { tests = value; } }
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
        public bool this[Education e]
        {
            get
            {
                return education == e;
            }
        }
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
            int k;
            if (tests != null)
            {
                buff = buff + "\nTests";
                k = tests.Count;
                for (int i = 0; i < k; i++)
                {
                    buff = buff + tests[i].ToString();
                    if (i < k - 1) buff = buff + ", ";
                    else buff = buff + ".";
                }
            }
            if (exams != null)
            {
                buff = buff + "\nPassed exams: ";
                k = exams.Count;
                for (int i = 0; i < k; i++)
                {
                    buff = buff + exams[i].ToString();
                    if (i < k - 1) buff = buff + ", ";
                    else buff = buff + ".";
                }
            }
            return "Education: " + education + "\nGroup: " + group + buff + "\n";
        }
        public override string ToShortString()
        {
            return "Education: " + education + "\nGroup: " + group + "\nMidle mark: " + GetMidleMark+ "\n";
        }
        public override bool Equals(object? obj)
        {
            if (obj == null)
            {
                return false;
            }
            Student student = (Student)obj;
            return 
                new Person(Name, Fname, Birthday).Equals(new Person(student.Name, student.Fname, student.Birthday)) && 
                education == student.Education && 
                group == student.Group && 
                exams == student.Exams && 
                tests == student.Tests;
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
        public object DeepCopy()
        {
            Person person = new Person(Name, Fname, Birthday); 
            Student student = new Student(person, education, group);
            student.Exams = exams;
            student.Tests = tests;
            return student;
        }
        
        public IEnumerator<Object> GetEnumerator()
        {
            for  (int i = 0; i < exams.Count; i++)
            {
                if (exams[i] != null)
                {
                    yield return (Exam)exams[i];
                }
                
            }
            for (int i = 0; i < tests.Count; i++)
            {
                if (tests[i] != null)
                {
                    yield return (Test)tests[i];
                }

            }
            
        }
        public IEnumerable<Exam> PassedExams(int min_mark)
        {
            
            if (exams != null)
            {
                for (int i = 0; i < exams.Count; i++)
                {
                    if (((Exam)exams[i]).Mark > min_mark)
                    {
                        yield return (Exam)exams[i];
                    }
                }
            }
            
        }
    }
}
