using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab
{
    [Serializable]
    class Test
    {
        public string name;
        public bool pass;
        public Test(string name, bool pass)
        {
            this.name = name;
            this.pass = pass;
        }
        public Test() : this("NotStated", false) { }
        public override string ToString()
        {
            string passed;
            if (pass) passed = ", passed";
            else passed = ", failed";
            return "Test " + name + passed;
        }
    }
}
