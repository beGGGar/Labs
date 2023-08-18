using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Linq;

namespace lab_2
{
    class Exam: IDateAndCopy
    {
        private string name;
        private int mark;
        private DateTime date;
        public Exam(string name_, int mark_, DateTime date_)
        {
            name = name_;
            mark = mark_;
            date = date_;
        }
        public Exam() : this("None", 0, new DateTime(2022, 1, 1))
        { }
        public string Name { get; set; }
        public int Mark { get { return mark; }  set { mark = value; } }
        public DateTime Date { get; set; }
        public override string ToString()
        {
            return name + ", балл: " + mark + ", " + date.ToLongDateString();
        }
        public override bool Equals(object? obj)
        {
            if (obj == null)
            {
                return false;
            }
            Exam exam = (Exam) obj;
            return name == exam.Name && mark == exam.Mark && date == exam.Date;
        }
        public override int GetHashCode()
        {
            unchecked
            {
                int hash = 17;
                hash = hash * 23 + name.GetHashCode();
                hash = hash * 23 + mark.GetHashCode();
                hash = hash * 23 + date.GetHashCode();
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
            Exam exam = new Exam(name, Mark, date);
            return exam;
        }
        DateTime IDateAndCopy.Date { get; set; }
    }
}
