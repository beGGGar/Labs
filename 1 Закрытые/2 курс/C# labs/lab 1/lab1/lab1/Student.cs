using System;
using System.Collections.Generic;
using System.Text;

namespace lab1
{
    class Student
    {
        private Person name;
        private Education education;
        private int group;
        private Exam[] exams;
        public Student(Person P, Education E, int group_)
        {
            name = P;
            education = E;
            group = group_;
            exams = new Exam[0];
            
        }
        public Student() : this(new Person(), Education.Bachelor, 0)
        { }
        public Person StudName
        {
            set { name = value; }
            get { return name; }
        }
        public Education Education
        {
            set { education = value; }
            get { return education; }
        }
        public int Group
        {
            set { group = value; }
            get { return group; }
        }
        public Exam[] Exams
        {
            set { exams = value; }
            get { return exams; }
        }
        public double GetMidleMark
        {
            get
            {
                double summ = 0;
                int k = exams.Length;
                if(k == 0)
                {
                    return 0;
                }
                for (int i = 0; i < k; i++)
                {
                    summ = summ + exams[i].Mark;
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
            Exam[] buffExam = exams;
            int k = exams.Length;
            exams = new Exam[exam.Length + k];
            buffExam.CopyTo(exams, 0);
            exam.CopyTo(exams, k);
        }
        public override string ToString()
        {
            int k = exams.Length;
            string buff = "";
            for(int i = 0; i<k; i++)
            {
                buff = buff + exams[i].Name + ", ";
            }
            return name.ToShortString() + "\nEducation: " + education + "\nGroup: " + group + "\nPassed exams: " + buff + "\n";
        }
        public virtual string ToShortString()
        {
            return name.ToShortString() + "\nEducation: " + education + "\nGroup: " + group + "\nMidle mark: " + GetMidleMark+ "\n";
        }
    }
}
