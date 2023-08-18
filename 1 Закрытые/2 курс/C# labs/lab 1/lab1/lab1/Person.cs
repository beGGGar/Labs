using System;
using System.Collections.Generic;
using System.Text;

namespace lab1
{
    class Person
    {
        private string name;
        private string fname;
        private DateTime birthday;
        public Person(string name_, string fname_, DateTime date)
        {
            name = name_;
            fname = fname_;
            birthday = date;
        }

        public Person(): this("NoName", "NoSurname", new DateTime(2022, 1, 1))
        {}

        public string Name
        {
            get { return name; }
            set { name = value; }
        }
        public string Fname
        {
            set { fname = value; }
            get { return fname; }
        }
        public DateTime Birthday
        {
            set { birthday = value;}
            get { return birthday; }
        }
        public int ChangeDate
        {
            set { new DateTime(value, birthday.Month, birthday.Day); }
            get { return birthday.Year; }
        }
        public override string ToString()
        {
            return name + " " + fname + " " + birthday.ToLongDateString();
        }
        public virtual string ToShortString()
        {
            return name + " " + fname;
        }
    }
}
