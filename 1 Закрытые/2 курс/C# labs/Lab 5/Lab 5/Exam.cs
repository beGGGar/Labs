using System;
using System.Collections.Generic;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Xml.Linq;

namespace Lab
{
    class Exam: IDateAndCopy, IComparable, IComparer<Exam>
    {
        #region fields, constructors
        private string name = "NotStated";
        private int mark = 0;
        public string Name { get { return name; } set { name = value; } }
        public int Mark 
        { 
            get { return mark; } 
            set { if (value <=100 && value >=0) mark = value; }
        }
        public DateTime Date { get; set; }
        public Exam(string name_, int mark_, DateTime date_)
        {
            Name = name_;
            Mark = mark_;
            Date = date_;
        }
        public Exam() : this("None", 0, new DateTime(2022, 1, 1)){ }
        #endregion

        #region methods, interfaces
        public override string ToString()
        {
            return Name + ", балл: " + Mark + ", " + Date.ToLongDateString();
        }
        public override bool Equals(object obj)
        {
            if (obj == null)
            {
                return false;
            }
            Exam exam = (Exam) obj;
            return Name == exam.Name && Mark == exam.Mark && Date == exam.Date;
        }
        public override int GetHashCode()
        {
            unchecked
            {
                int hash = 17;
                hash = hash * 23 + Name.GetHashCode();
                hash = hash * 23 + Mark.GetHashCode();
                hash = hash * 23 + Date.GetHashCode();
                return hash;
            }
        }
        public static bool operator ==(Exam one, Exam two)
        {
            return one.Equals(two);

        }
        public static bool operator !=(Exam one, Exam two)
        {
            return !one.Equals(two);
        }
        object IDateAndCopy.DeepCopy()
        {
            Exam exam = new Exam(Name, Mark, Date);
            return exam;
        }

        public int CompareTo(object obj)
        {
            Exam exam = obj as Exam;
            if (exam.Name != null)
            {
                return Name.CompareTo(exam.Name);
            }
            throw new InvalidCastException("Нет объекта для сравнения"); 
        }

        public int Compare(Exam x, Exam y)
        {
            if (x == null || y == null) return 0;
            if (x.Mark == y.Mark) return 0;
            return x.Mark < y.Mark ? -1 : 1;
        }

        DateTime IDateAndCopy.Date { get; set; }
        #endregion
    }
}
