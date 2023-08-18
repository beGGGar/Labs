using System;
using System.Collections.Generic;
using System.Text;

namespace Lab
{

    class StudentsChangedEventArgs<TKey>: EventArgs
    {
        public string CollectionName { get; set; }
        public Action Act { get; set; }
        public string PropertyName { get; set; } = "";
        public TKey ElementKey { get; set; }
        public StudentsChangedEventArgs(string collname, Action A, string propertyName, TKey key)
        {
            CollectionName = collname;
            Act = A;
            if (Act == Action.Add || Act == Action.Remove) PropertyName = "";
            else PropertyName = propertyName;
            ElementKey = key;
        }

        public override string ToString()
        {
            return "\nCollection " + CollectionName + "\nAction " + Act.ToString() + "\nProperty used: " + PropertyName + "\nKey " + ElementKey.ToString();
        }
        
    }
}
