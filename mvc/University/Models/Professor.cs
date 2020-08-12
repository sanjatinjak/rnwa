using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace University.Models
{
    [Table("professors")]
    public class Professor
    {
        public int ProfessorId { get; set; }
        public String Name { get; set; }
        public int DepartamentId { get; set; }
    }
}
