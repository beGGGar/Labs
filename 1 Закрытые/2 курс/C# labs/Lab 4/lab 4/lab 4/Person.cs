//using lab;
using System;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using System.Text;

namespace Lab
{
    public class Person: IDateAndCopy
    {
        protected string name;
        protected string fname;
        protected DateTime birthday;
        public Person(string name_, string fname_, DateTime date)
        {
            name = name_;
            fname = fname_;
            birthday = date;
        }

        public Person(): this("NameNotStated", "SurnameNotStated", new DateTime()){}

        public string Name { get { return name; } set { name = value; } }
        public string Fname { get { return fname; } set { fname = value; } }
        public DateTime Birthday { get { return birthday; } set { birthday = value; } }
        public int ChangeBirthdayYear
        {
            set { new DateTime(value, birthday.Month, birthday.Day); }
            get { return birthday.Year; }
        }
        public override string ToString()
        {
            
            return ("Name: " + name + "\nSurname: " + fname + "\nBirthday: " + birthday.ToLongDateString() + "\n");
        }
        public virtual string ToShortString()
        {
            return name + " " + fname;
        }
        public override bool Equals(object obj)
        {
            if (obj == null)
            {
                return false;
            }
            Person person = (Person)obj;
            return 
                name.Equals(person.Name) && 
                fname.Equals(person.Fname) && 
                birthday.Equals(person.Birthday);
        }
        public override int GetHashCode()
        {
            unchecked
            {
                int hash = 17;
                hash = hash * 23 + name.GetHashCode();
                hash = hash * 23 + fname.GetHashCode();
                hash = hash * 23 + birthday.GetHashCode();
                return hash;
            }
        }
        public static bool operator ==(Person one, Person two)
        {
            return one.Equals(two);

        }
        public static bool operator !=(Person one, Person two)
        {
            return !one.Equals(two);
        }
        object IDateAndCopy.DeepCopy()
        {
            Person person = new Person(name, fname, birthday);
            return person;
        }
        DateTime IDateAndCopy.Date { get; set; }
    }
}
