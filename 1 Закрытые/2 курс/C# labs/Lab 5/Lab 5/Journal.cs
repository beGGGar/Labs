using Lab;
using System;
using System.Collections.Generic;
using System.Text;

namespace Lab
{
    class Journal
    {
        private List<JournalEntry> journals = new List<JournalEntry>();
        public override string ToString()
        {
            if (journals.Count <= 0) return "No element in list!";
            string str = "Journals";
            foreach (var item in journals)
            {
                str = str + item.ToString();
            }
            return str;
        }
        public void StudentsChanged(object obj, EventArgs e)
        {
            var Event = e as StudentsChangedEventArgs<string>;
            if (Event != null) {
                JournalEntry je = new JournalEntry(Event.CollectionName, Event.Act, Event.PropertyName, Event.ElementKey.ToString());
                journals.Add(je);
            }
            
        }
    }

    class JournalEntry
    {
        public string CollectionName { get; set; }
        public Lab.Action Act { get; set; }
        public string PropertyName { get; set; } = "";
        public string Key { get; set; }
        public JournalEntry(string name, Lab.Action A, string propertyName, string key)
        {
            CollectionName = name;
            Act = A;
            PropertyName = propertyName;
            Key = key;
        }
        public override string ToString()
        {
            return "\nCollection: " + CollectionName + "\nAction: " + Act.ToString() + "\nProperty used: " + PropertyName + "\nKey: " + Key + "\n";
        }
    }
}
