//﻿using System;
//using System.Collections.Generic;
//using System.Text;
//using System.Collections;
//using System.IO;
//using System.Runtime.Serialization.Formatters.Binary;

//namespace lab_1_Csharp_v1._0

//{
//    [Serializable]
//    class Magazine : Edition, IRateAndCopy, IEnumerable
//    {
//        private Frequency how_often;
//        private System.Collections.Generic.List<Person> list_of_Editors;
//        private System.Collections.Generic.List<Article> list_of_Articles;


//        //field of methods for lab5 level1
//        public Magazine DeepCopySerialization()
//        {
//            MemoryStream stream = new MemoryStream();
//            try
//            {
//                BinaryFormatter converter = new BinaryFormatter();
//                converter.Serialize(stream, this);
//                stream.Position = 0;
//                return converter.Deserialize(stream) as Magazine;
//            }
//            catch
//            {
//                Console.WriteLine();
//                Console.WriteLine("Some problems in try-block in Serialize.");
//                throw new Exception("Some problems in try-block in Serialize.");
//            }
//            finally
//            {
//                stream.Close();
//            }
//        }
//        public bool Save(string filename)
//        {
//            Stream file = null;
//            if (File.Exists(filename))
//            {
//                try
//                {
//                    file = File.Open(filename, FileMode.Append);
//                    BinaryFormatter converter = new BinaryFormatter();
//                    converter.Serialize(file, this);
//                    file.Close();
//                    return true;
//                }
//                catch
//                {
//                    Console.WriteLine("Some problems with saving to file: " + filename);
//                    file?.Close();
//                    return false;
//                }
//                finally
//                {
//                    file?.Close();
//                }
//            }
//            else
//            {
//                try
//                {
//                    file = File.Create(filename);
//                    file.Close();
//                    file = File.Open(filename, FileMode.Append);
//                    BinaryFormatter converter = new BinaryFormatter();
//                    converter.Serialize(file, this);
//                    file.Close();
//                    return true;
//                }
//                catch
//                {
//                    Console.WriteLine("Some problems with saving to created file: " + filename);
//                    file?.Close();
//                    return false;
//                }
//                finally
//                {
//                    file?.Close();
//                }
//            }
//        }
//        public bool Load(string filename)
//        {
//            Stream file = null;
//            if (File.Exists(filename))
//            {
//                try
//                {
//                    file = File.OpenRead(filename);
//                    BinaryFormatter converter = new BinaryFormatter();
//                    Magazine obj= converter.Deserialize(file) as Magazine;
//                    file.Close();
//                    this.edition_name = obj.edition_name;
//                    this.edition_DateOfPublish = obj.edition_DateOfPublish;
//                    this.edition_number = obj.edition_number;
//                    this.how_often = obj.how_often;
//                    this.list_of_Articles = new List<Article>(obj.list_of_Articles);
//                    this.list_of_Editors = new List<Person>(obj.list_of_Editors);
//                    return true;
//                }
//                catch
//                {
//                    Console.WriteLine("Some problems in loading in file: "+filename);
//                    file?.Close();
//                    return false;
//                }
//                finally
//                {
//                    file?.Close();
//                }
//            }
//            else
//            {
//                Console.WriteLine("File: "+filename+" does not exist!");
//                return false;
//            }
//        }
//        public static bool Save(string filename, ref Magazine obj)
//        {
//            Stream file = null;
//            if (File.Exists(filename))
//            {
//                try
//                {
//                    file = File.Open(filename, FileMode.Append);
//                    BinaryFormatter converter = new BinaryFormatter();
//                    converter.Serialize(file, obj);
//                    file.Close();
//                    return true;
//                }
//                catch
//                {
//                    Console.WriteLine("Some problems with static saving to file: " + filename);
//                    file?.Close();
//                    return false;
//                }
//                finally
//                {
//                    file?.Close();
//                }
//            }
//            else
//            {
//                try
//                {
//                    file = File.Create(filename);
//                    file.Close();
//                    file = File.Open(filename, FileMode.Append);
//                    BinaryFormatter converter = new BinaryFormatter();
//                    converter.Serialize(file, obj);
//                    file.Close();
//                    return true;
//                }
//                catch
//                {
//                    Console.WriteLine("Some problems with static saving to created file: " + filename);
//                    file?.Close();
//                    return false;
//                }
//                finally
//                {
//                    file?.Close();
//                }
//            }
//        }
//        public static bool Load(string filename, ref Magazine obj)
//        {
//            Stream file = null;
//            if (File.Exists(filename))
//            {
//                try
//                {
//                    file = File.OpenRead(filename);
//                    BinaryFormatter converter = new BinaryFormatter();
//                    obj = converter.Deserialize(file) as Magazine;
//                    file.Close();
//                    return true;
//                }
//                catch
//                {
//                    Console.WriteLine("Some problems in static loading in file: " + filename);
//                    file?.Close();
//                    return false;
//                }
//                finally
//                {
//                    file?.Close();
//                }
//            }
//            else
//            {
//                Console.WriteLine("File: " + filename + " does not exist!");
//                return false;
//            }
//        }
//        public bool AddFromConsole()
//        {
//            Console.WriteLine("\nInput Article's data. Fromat: \nArticle name(string) # Autor name(string) # Autor sername(string) # Autor date of birthh(dd.mm.yyyy) # Article rate(double)");
//            Console.WriteLine("\nSplit Symbols # - <!>, <@>, <#>, <,>, <$>, <&>, </>");
//            try
//            {
//                string[] args = Console.ReadLine().Split('!', '@', '#', ',', '$', '&', '/');
//                if (args.Length >= 5)
//                {
//                    Article obj = new Article();
//                    obj.article_name = args[0];
//                    obj.person.Name = args[1];
//                    obj.person.Surname = args[2];
//                    obj.person.Birthday = Convert.ToDateTime(args[3]);
//                    obj.article_rate = Convert.ToDouble(args[4]);
//                    list_of_Articles.Add(obj);
//                    return true;
//                }
//                else
//                {
//                    Console.WriteLine("Wrong args count");
//                    return false;
//                }
//            }
//            catch
//            {
//                Console.WriteLine("Some problems with separating or Converting in AddFromConsole");
//                return false;
//            }
//        }
//        //end of field


//        public override bool Equals(Object obj_value)
//        {
//            if (obj_value == null)
//                return false;
//            Magazine obj = obj_value as Magazine;
//            return edition_name.Equals(obj.edition_name) && how_often == obj.how_often && edition_DateOfPublish.Equals(obj.edition_DateOfPublish) && edition_number.Equals(obj.edition_number) && list_of_Articles.Equals(obj.list_of_Articles);
//        }

//        public static bool operator ==(Magazine obj1, Magazine obj2)
//        {
//            return obj1.edition_name.Equals(obj2.edition_name) && obj1.how_often == obj2.how_often && obj1.edition_DateOfPublish.Equals(obj2.edition_DateOfPublish) && obj1.edition_number.Equals(obj2.edition_number) && obj1.list_of_Articles.Equals(obj2.list_of_Articles);
//        }

//        public static bool operator !=(Magazine obj1, Magazine obj2)
//        {
//            return !obj1.edition_name.Equals(obj2.edition_name) || obj1.how_often != obj2.how_often || !obj1.edition_DateOfPublish.Equals(obj2.edition_DateOfPublish) || !obj1.edition_number.Equals(obj2.edition_number) || !obj1.list_of_Articles.Equals(obj2.list_of_Articles);
//        }

//        public override int GetHashCode()
//        {
//            return how_often.GetHashCode() ^ list_of_Editors.GetHashCode() ^ list_of_Articles.GetHashCode() ^ edition_number.GetHashCode() ^ edition_name.GetHashCode() ^ edition_DateOfPublish.GetHashCode();
//        }

//        public override object DeepCopy()
//        {
//            Magazine obj = new Magazine();
//            obj.edition_name = edition_name;
//            obj.Edition_DateOfPublish = Edition_DateOfPublish;
//            obj.edition_number = edition_number;
//            obj.how_often = how_often;
//            obj.List_of_Editors = new List<Person>(obj.List_of_Editors.Count + list_of_Editors.Count);
//            obj.list_of_Editors.AddRange(list_of_Editors);
//            obj.List_of_Articles = new List<Article>(obj.List_of_Articles.Count + list_of_Articles.Count);
//            obj.list_of_Articles.AddRange(list_of_Articles);
//            return obj;
//        }

//        public Edition Edition
//        {
//            get
//            {
//                return new Edition(edition_name, edition_DateOfPublish, edition_number);
//            }
//            set
//            {
//                edition_name = value.Edition_name;
//                Edition_DateOfPublish = value.Edition_DateOfPublish;
//                edition_number = value.Edition_number;
//            }
//        }


//        public Magazine(string edition_nameValue, Frequency how_oftenValue, DateTime edition_DayOfPublishValue, int edition_numberValue)
//        {
//            edition_name = edition_nameValue;
//            how_often = how_oftenValue;
//            edition_DateOfPublish = edition_DayOfPublishValue;
//            edition_number = edition_numberValue;
//            list_of_Editors = new List<Person>();
//            list_of_Articles = new List<Article>();
//        }
//        public Magazine()
//        {
//            edition_name = null;
//            how_often = 0;
//            edition_DateOfPublish= new DateTime();
//            edition_number = 0;
//            list_of_Editors = new List<Person>();
//            list_of_Articles = new List<Article>();
//        }
        
//        public Frequency How_often
//        {
//            get
//            {
//                return how_often;
//            }
//            set
//            {
//                how_often = value;
//            }
//        }

//        public double Rating
//        {
//            get
//            {
//                double rate = 0;
//                if (list_of_Articles.Count == 0)
//                {
//                    return rate = 0;
//                }
//                foreach (Article element in list_of_Articles)
//                {
//                    rate += element.article_rate;
//                }
//                return rate / list_of_Articles.Count;
//            }
//        }

//        public List<Article> List_of_Articles
//        {
//            get
//            {
//                return list_of_Articles;
//            }
//            set
//            {
//                list_of_Articles.AddRange(value);
//            }
//        }

//        public List<Person> List_of_Editors
//        {
//            get
//            {
//                return list_of_Editors;
//            }
//            set
//            {
//                list_of_Editors.AddRange(value);
//            }
//        }

//        public void AddArticles(params Article[] mas)
//        {
//            list_of_Articles.AddRange(mas);
//        }

//        public void AddEditors(params Person[] mas)
//        {
//            list_of_Editors.AddRange(mas);
//        }
//        public bool this[Frequency index]
//        {
//            get
//            {
//                return how_often == index;
//            }
//        }

//        public override string ToString()
//        {
//            string result="";
//            result += edition_name + " " + edition_DateOfPublish.ToShortDateString() + " " + edition_number + " " + how_often;
//            result+= "\narticles:";
//            foreach(Article element in list_of_Articles)
//            {
//                result+= "\n" + element.ToString();
//            }
//            result += "\neditors:";
//            foreach (Person element in list_of_Editors)
//            {
//                result+= "\n" + element.ToString();
//            }
//            return result;

//        }
//        public virtual string ToShortString()
//        {
//            return edition_name + " " + edition_DateOfPublish.ToShortDateString() + " " + edition_number +" " + how_often + " " + Rating+"\n";
//        }

//        public IEnumerator GetEnumerator()
//        {
//            return new MagazineEnumerator(list_of_Articles, list_of_Editors);
//        }

//        public IEnumerable GetAutorsWhoAreEditors()
//        {
//            foreach  (Article element in list_of_Articles)
//            {
//                if (list_of_Editors.Contains(element.person))
//                    yield return element;
//            }
//        }

//        public IEnumerable GetEditorsWithNoArticles()
//        {
//            foreach (Article element in list_of_Articles)
//            {
//                if (!list_of_Editors.Contains(element.person))
//                    yield return element.person;
//            }
//        }

//        public void Sort_by_article_name()
//        {
//            list_of_Articles.Sort();
//        }

//        public void Sort_by_person_Surname()
//        {
//            list_of_Articles.Sort(new Article());
//        }

//        public void Sort_by_article_rate()
//        {
//            list_of_Articles.Sort(new ArticleSortByRating());
//        }
//    }
//}