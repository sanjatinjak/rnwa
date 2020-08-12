using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace University.Models
{
    [Table("courses")]
    public class Courses
    {
        [Key]
        public int CourseId { get; set; }
        public String Name { get; set; }

        public int Professors_ProfessorId { get; set; }

        public int Departaments_DepartamentId { get; set; }
    }
}
