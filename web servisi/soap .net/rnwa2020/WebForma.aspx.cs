using EO.Internal;
using rnwa2020.ServiceReference1;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using EO.WebEngine;

namespace rnwa2020
{
    public partial class WebForma : System.Web.UI.Page
    {
        private ArrayOfStudents s;

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void dugme_Click(object sender, EventArgs e)
        {

            CourseIdSoapClient klient = new CourseIdSoapClient("CourseIdSoap");

            int id = int.Parse(Request.Form["unos"]);

            s = klient.GetStudentInfo(id);

            if (s != null)
            {
                rezultat.InnerHtml = "";

                foreach (ServiceReference1.students st in s)
                {
                    rezultat.InnerHtml += "&#8195;&#8195;&#8195;&#8195;" + st.StudentId + "&#8195;&#8195;&#8195;&#8195;&#8195;" + st.Faculties_FacultyId + "&#8195;&#8195;&#8195;&#8195;&#8195;" + st.Name + " <br />";


                }

            }


        }


    }

}
