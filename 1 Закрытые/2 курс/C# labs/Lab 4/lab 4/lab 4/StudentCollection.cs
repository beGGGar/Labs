using Microsoft.VisualBasic;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Lab
{
    delegate TKey KeySelector<TKey>(Student st);
    delegate void StudentsChangedHandler<TKey>(object source, StudentsChangedEventArgs<TKey> args);


    class StudentCollection<TKey>
    {
        #region fields
        private Dictionary<TKey, Student> students = new Dictionary<TKey, Student>();
        private KeySelector<TKey> method;
        public StudentsChangedHandler<TKey> StudentChanged;
        #endregion
        #region constructors
        public StudentCollection(KeySelector<TKey> method)
        {
            this.method = method;
        }
        #endregion
        #region properities
        public double MaxMidleMark
        {
            get
            {
                if (students.Count > 0) return students.Values.Max(student => student.GetMidleMark);
                else return -1;
            }
        }
        public string CollectionName { get; set; }
        #endregion
        #region methods
        public bool Remove(Student st)
        {
            if (students.ContainsValue(st))
            {
                foreach (var item in students.Where(student => student.Value == st))//.ToList())
                {
                    students.Remove(item.Key);
                    StudentPropertyChanged(Lab.Action.Remove, "None", method(st));
                    st.PropertyChanged-= HandleEvent;
                    return true;
                }
            }
            return false;
        }
        public void AddDefaults()
        {
            Person person1 = new Person("Марк", "Поло", new DateTime(2003, 4, 12));
            Person person2 = new Person("Павел", "Павлов", new DateTime(2004, 5, 5));
            Person person3 = new Person("Димас", "Крутой", new DateTime(2002, 3, 22));
            Student student1 = new Student(person1, Enums.Bachelor, 22);
            Student student2 = new Student(person2, Enums.SecondEducation, 3);
            Student student3 = new Student(person3, Enums.Specialist, 9);
            Exam[] exams1 = new Exam[] { new Exam("Матан", 2, new DateTime(2020, 4, 12)), new Exam("Инглиш", 4, new DateTime(2020, 7, 15)) };
            Exam[] exams2 = new Exam[] { new Exam("Пение", 4, new DateTime(2020, 5, 13)), new Exam("Сатанизм", 5, new DateTime(2020, 8, 16)) };
            Exam[] exams3 = new Exam[] { new Exam("Культизм", 5, new DateTime(2020, 6, 14)), new Exam("История веры", 2, new DateTime(2020, 9, 17)) };
            student1.AddExams(exams1);
            student2.AddExams(exams2);
            student3.AddExams(exams3);
            students.Add(method(student1), student1);
            students.Add(method(student2), student2);
            students.Add(method(student3), student3);

        }
        private void HandleEvent(object subject, EventArgs e)
        {
            var it = (PropertyChangedEventArgs)e;
            var student = subject as Student;
            var key = method(student);
            StudentPropertyChanged(Lab.Action.Property, it.PropertyName, key);
        }
        public void AddStudents(params Student[] st)
        {
            foreach (var student in st)
            {
                students.Add(method(student), student);
                StudentPropertyChanged(Lab.Action.Add, "None", method(student));
                student.PropertyChanged += HandleEvent;
            }
        }
        

        private void StudentPropertyChanged(Action A, string? propertyName, TKey? key)
        {
            StudentChanged?.Invoke(this, new StudentsChangedEventArgs<TKey>(CollectionName, A, propertyName, key));
        }

        public override string ToString()
        {
            string str = $"{students.Count} студентов:\n";
            foreach (var student in students.Values)
            {
                str += student.ToString() + "\n";
            }
            return str;
        }
        public string ToShortString()
        {
            string str = "";
            foreach(var student in students.Values)
            {
                str += student.ToShortString();
            }
            return str;
        }
        #endregion
        #region interfaces
        public IEnumerable<IGrouping<Enums, KeyValuePair<TKey, Student>>> groupStudentsByEducation
        {
            get
            {
                return students.GroupBy(student => student.Value.Education);
            }
        }
        public IEnumerable<KeyValuePair<TKey, Student>> EducationForm(Enums value)
        {
            return students.Where(student => student.Value.Education == value);
        }
        #endregion

    }
}
