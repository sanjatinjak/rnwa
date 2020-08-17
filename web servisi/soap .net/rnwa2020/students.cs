namespace rnwa2020
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class students
    {
        [Key]
        [Column(Order = 0)]
        public int StudentId { get; set; }

        [Required]
        [StringLength(45)]
        public string Name { get; set; }

        [Key]
        [Column(Order = 1)]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int Faculties_FacultyId { get; set; }

    }
}
