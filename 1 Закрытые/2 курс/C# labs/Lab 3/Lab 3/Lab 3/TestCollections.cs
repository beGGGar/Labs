using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Lab
{
    class TestCollections<TKey, TValue>
    {
        private List<TKey> keyList = new List<TKey>();
        private List<String> stringList = new List<string>();
        private Dictionary<TKey, TValue> dictionaryTKey = new Dictionary<TKey, TValue>();
        private Dictionary<string, TValue> dictionaryString = new Dictionary<string, TValue>();
        private GenerateElement<TKey, TValue> generateMethod;

        public TestCollections(int count, GenerateElement<TKey, TValue> method)
        {
            generateMethod = method;
            for (int i = 0; i < count; i++)
            {
                keyList.Add(generateMethod(i).Key);
                stringList.Add(generateMethod(i).Value.ToString());
                dictionaryTKey.Add(generateMethod(i).Key, generateMethod(i).Value);
                dictionaryString.Add(generateMethod(i).Key.ToString(), generateMethod(i).Value);  
                
            }
        }
        public void searchKeyList()
        {
            Console.WriteLine("\nTime search in keyList");
            var first = keyList[0];
            var middle = keyList[keyList.Count/2];
            var last = keyList[keyList.Count-1];
            var nonExist = generateMethod(keyList.Count + 1).Key;
            Stopwatch sw = new Stopwatch();
            sw.Start();
            keyList.Contains(first);
            sw.Stop();
            Console.WriteLine("Find first elem for {0} sec", sw.Elapsed);

            sw.Start();
            keyList.Contains(middle);
            sw.Stop();
            Console.WriteLine("Find midle elem for {0} sec", sw.Elapsed);

            sw.Start();
            keyList.Contains(last);
            sw.Stop();
            Console.WriteLine("Find last elem for {0} sec", sw.Elapsed);

            sw.Start();
            keyList.Contains(nonExist);
            sw.Stop();
            Console.WriteLine("Find nonexist elem for {0} sec", sw.Elapsed);
        }
        public void searchStringList()
        {
            Console.WriteLine("\nTime search in strList");
            var first = stringList[0];
            var middle = stringList[keyList.Count / 2];
            var last = stringList[keyList.Count - 1];
            var nonExist = generateMethod(stringList.Count + 1).ToString();
            Stopwatch sw = new Stopwatch();
            sw.Start();
            stringList.Contains(first);
            sw.Stop();
            Console.WriteLine("Find first elem for {0} sec", sw.Elapsed);

            sw.Start();
            stringList.Contains(middle);
            sw.Stop();
            Console.WriteLine("Find midle elem for {0} sec", sw.Elapsed);

            sw.Start();
            stringList.Contains(last);
            sw.Stop();
            Console.WriteLine("Find last elem for {0} sec", sw.Elapsed);

            sw.Start();
            stringList.Contains(nonExist);
            sw.Stop();
            Console.WriteLine("Find nonexist elem for {0} sec", sw.Elapsed);
        }

        public void searchDictionaryTKeyKey()
        {
            Console.WriteLine("\nTime search in keyDict with ContainsKey");

            var first = dictionaryTKey.ElementAt(0).Key;
            var middle = dictionaryTKey.ElementAt(dictionaryTKey.Count / 2).Key;
            var last = dictionaryTKey.ElementAt(dictionaryTKey.Count - 1).Key;
            var nonExist = generateMethod(dictionaryTKey.Count + 1).Key;

            Stopwatch sw = new Stopwatch();
            sw.Start();
            dictionaryTKey.ContainsKey(first);
            sw.Stop();
            Console.WriteLine("Find first elem for {0} sec", sw.Elapsed);

            sw.Start();
            dictionaryTKey.ContainsKey(middle);
            sw.Stop();
            Console.WriteLine("Find midle elem for {0} sec", sw.Elapsed);

            sw.Start();
            dictionaryTKey.ContainsKey(last);
            sw.Stop();
            Console.WriteLine("Find last elem for {0} sec", sw.Elapsed);

            sw.Start();
            dictionaryTKey.ContainsKey(nonExist);
            sw.Stop();
            Console.WriteLine("Find nonexist elem for {0} sec", sw.Elapsed);
        }

        public void searchDictionaryStringKey()
        {
            Console.WriteLine("\nTime search in stringDict with ContainsKey");

            var first = dictionaryString.ElementAt(0).Key;
            var middle = dictionaryString.ElementAt(dictionaryString.Count / 2).Key;
            var last = dictionaryString.ElementAt(dictionaryString.Count - 1).Key;
            var nonExist = generateMethod(dictionaryString.Count + 1).Key.ToString();

            Stopwatch sw = new Stopwatch();
            sw.Start();
            dictionaryString.ContainsKey(first);
            sw.Stop();
            Console.WriteLine("Find first elem for {0} sec", sw.Elapsed);

            sw.Start();
            dictionaryString.ContainsKey(middle);
            sw.Stop();
            Console.WriteLine("Find midle elem for {0} sec", sw.Elapsed);

            sw.Start();
            dictionaryString.ContainsKey(last);
            sw.Stop();
            Console.WriteLine("Find last elem for {0} sec", sw.Elapsed);

            sw.Start();
            dictionaryString.ContainsKey(nonExist);
            sw.Stop();
            Console.WriteLine("Find nonexist elem for {0} sec", sw.Elapsed);
        }

        public void searchDictionaryTKeyValue()
        {
            Console.WriteLine("\nTime search in keyDict with ContainsValue");

            var first = dictionaryTKey.ElementAt(0).Value;
            var middle = dictionaryTKey.ElementAt(dictionaryTKey.Count / 2).Value;
            var last = dictionaryTKey.ElementAt(dictionaryTKey.Count - 1).Value;
            var nonExist = generateMethod(dictionaryTKey.Count + 1).Value;

            Stopwatch sw = new Stopwatch();
            sw.Start();
            dictionaryTKey.ContainsValue(first);
            sw.Stop();
            Console.WriteLine("Find first elem for {0} sec", sw.Elapsed);

            sw.Start();
            dictionaryTKey.ContainsValue(middle);
            sw.Stop();
            Console.WriteLine("Find midle elem for {0} sec", sw.Elapsed);

            sw.Start();
            dictionaryTKey.ContainsValue(last);
            sw.Stop();
            Console.WriteLine("Find last elem for {0} sec", sw.Elapsed);

            sw.Start();
            dictionaryTKey.ContainsValue(nonExist);
            sw.Stop();
            Console.WriteLine("Find nonexist elem for {0} sec", sw.Elapsed);
        }
    }
}
