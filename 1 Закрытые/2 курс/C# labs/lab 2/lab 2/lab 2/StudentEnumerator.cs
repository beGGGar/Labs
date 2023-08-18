//using System;
//using System.Collections;
//using System.Collections.Generic;
//using System.Linq;
//using System.Text;
//using System.Threading.Tasks;

//namespace lab_2
//{
//    public class StudentEnumerator: IEnumerator
//    {
//        private Test[] tests;
//        private Exam[] exams;
//        private int pointer = -1;

//        public StudentEnumerator(ArrayList tests, ArrayList exams)
//        {
//            this.tests = (Test)tests.;
//            this.exams = exams;
//        }
//        public StudentEnumerator() : this(new ArrayList(0), new ArrayList(0)) { }
//        public object Current
//        {
//            get
//            {
//                if (pointer == -1 || pointer >= exams.Count)
//                    throw new IndexOutOfRangeException();
//                return exams[pointer];
//            }
//        }
            
//        public bool MoveNext()
//        {
//            if (pointer < exams.Count - 1)
//            {
//                pointer++;
//                while (persons.Contains(((Exam)exams[pointer]).person) && pointer < exams.Count - 1)
//                {
//                    position++;
//                }
//                if (!persons.Contains(((Article)articles[position]).person))
//                    return true;
//                return false;
//            }
//            return false;

//            void Reset()
//        {
//                pointer = -1;
//            }
//    }
//}
