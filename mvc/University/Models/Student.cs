using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace University.Models
{
    [Table("students")]
    public class Student
    {
        public int StudentId { get; set; }
        public String Name { get; set; }
        public int Faculties_FacultyId { get; set; }

    }
}
