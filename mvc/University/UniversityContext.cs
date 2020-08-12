using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using University.Models;

namespace University
{
    public class UniversityContext : DbContext
    {
        public UniversityContext(DbContextOptions<UniversityContext> options): base (options) { }
        public DbSet<University.Models.Professor> Professor { get; set; }
        public DbSet<University.Models.Courses> Courses { get; set; }
        public DbSet<University.Models.Student> Student { get; set; }

     
    }
}
