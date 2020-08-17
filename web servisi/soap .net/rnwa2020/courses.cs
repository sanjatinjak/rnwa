namespace rnwa2020
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class courses
    {
        [Key]
        [Column(Order = 0)]
        public int CourseId { get; set; }

        [Required]
        [StringLength(45)]
        public string Name { get; set; }

        [Key]
        [Column(Order = 1)]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int Professors_ProfessorId { get; set; }

        [Key]
        [Column(Order = 2)]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int Departaments_DepartamentId { get; set; }
    }
}
