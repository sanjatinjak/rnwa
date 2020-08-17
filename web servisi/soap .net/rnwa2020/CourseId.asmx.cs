using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace rnwa2020
{
    /// <summary>
    /// Summary description for CourseId
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class CourseId : System.Web.Services.WebService
    {
        UniversityModel uni = new UniversityModel();
        public List<int> crs = new List<int>();
        public List<students> stud = new List<students>();
        public students s;

        [WebMethod]
        public List<students> GetStudentInfo (int id)
        {


            // dohvaćam sve id studenata koji slusaju trazeni kolegij
            crs = uni.students_courses.Where(x => x.Courses_CourseId == id).Select(x => x.Students_StudentId).ToList();

            foreach(int i in crs)
            {
                s = uni.students.First(x => x.StudentId == i);
                stud.Add(s);
            }

            return stud;

        }
    }
}
