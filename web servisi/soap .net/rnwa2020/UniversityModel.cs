namespace rnwa2020
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class UniversityModel : DbContext
    {
        public UniversityModel()
            : base("name=uniModel")
        {
        }

        public virtual DbSet<courses> courses { get; set; }
        public virtual DbSet<students> students { get; set; }
        public virtual DbSet<students_courses> students_courses { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<courses>()
                .Property(e => e.Name)
                .IsUnicode(false);

            modelBuilder.Entity<students>()
                .Property(e => e.Name)
                .IsUnicode(false);
        }
    }
}
