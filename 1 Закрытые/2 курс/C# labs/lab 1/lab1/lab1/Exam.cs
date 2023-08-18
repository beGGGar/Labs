using System;
using System.Collections.Generic;
using System.Text;

namespace lab1
{
    class Exam
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
        public override string ToString()
        {
            return name + " " + mark + " " + date.ToLongDateString();
        }
        public string Name
        {
            set { name = value; }
            get { return name; }
        }
        public int Mark
        {
            set { mark = value; }
            get { return mark; }
        }
        public DateTime Date
        {
            set { date = value; }
            get { return date; }
        }
    }
}
