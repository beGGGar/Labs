using Lab;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab
{
    class ComparerExam : IComparer<Exam>
    {
        public int Compare(Exam x, Exam y)
        {
            if (x == null || y == null) return 0;
            DateTime xDay = x.Date;
            DateTime yDay = y.Date;
            return xDay.Date.CompareTo(yDay);
            //if (x.Date == y.Date) return 0;
            //return x.Date < y.Date ? -1 : 1;
            
        }
    }
}
