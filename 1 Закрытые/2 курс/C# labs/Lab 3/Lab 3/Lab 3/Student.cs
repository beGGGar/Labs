﻿using System;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using System.Text;
using System.Xml.Linq;

namespace Lab
{
    class Student: Person, IDateAndCopy
    {
        private Education education;
        private int group;
        private List<Test> tests;
        private List<Exam> exams;
        
        public Person StudName
        {
            get { return new Person(name, fname, birthday); }
            set { name = value.Name;
                fname = value.Fname;
                birthday = value.Birthday;
            }
        }
        public Education Education { 
            get { return education; } 
            set { education = value; } }
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
        public Student(Person P, Education E, int group_) : base(P.Name, P.Fname, P.Birthday)
        {
            education = E;
            group = group_;
            tests = new List<Test>();
            exams = new List<Exam>();
        }
        public Student() : this(new Person(), Education.Bachelor, 0)
        { }
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
        public override bool Equals(object? obj)
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
    }
}
