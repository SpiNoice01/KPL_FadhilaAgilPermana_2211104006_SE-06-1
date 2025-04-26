
<div align="center">
TUGAS PENDAHULUAN <br>
KONSTRUKSI PERANGKAT LUNAK <br>
<br>
<!-- MODUL I <br> -->
<!-- JUDUL -->
 <br>

<img src="https://lac.telkomuniversity.ac.id/wp-content/uploads/2021/01/cropped-1200px-Telkom_University_Logo.svg-270x270.png" width="250px">

<br>

Disusun Oleh: <br>
Fadhila Agil Permana | 2211104006<br>
SE-06-01 <br>

<br>

Asisten Praktikum : <br>
Naufal El Kamil Aditya Pratama Rahman <br>
Imelda Alfina Palupi Dewi <br>

<br>

Dosen Pengampu : <br>
Yudha Islami Sulistya, S.Kom., M.Cs <br>

<br>

PROGRAM STUDI S1 REKAYASSA PERANGKAT LUNAK <br>
FAKULTAS INFORMATIKA <br> 
TELKOM UNIVERSITY PURWOKERTO <br>

<hr>

</div>
<!-- ====================================================== -->


### Bagian 1, ASP Core Net API  Dan Penamaan
<img src="Res_IMG\TP\1.png">

<!-- ====================================================== -->
### Bagian 2: Coba Run, kalo baru jalanin nanti setuju2 saja karena akan menginstall package yang dibutuhkan

<img src="Res_IMG\TP\2.png">

<!-- ====================================================== -->
### Bagian 3: Add Folder Baru, dan didalam folder add models file

<img src="Res_IMG\Jurnal\3.png">

<!-- ====================================================== -->
### Bagian 3: Code

> Models
```cs
namespace modul9_NIM.Models
{
    public class Movie
    {
        public string Title { get; set; }
        public string Director { get; set; }
        public List<string> Stars { get; set; }
        public string Description { get; set; }

        public Movie()
        {
        }
    }
}

```

> Main Code di dalam controller
```cs
using Microsoft.AspNetCore.Mvc;
using modul9_NIM.Models;

namespace modul9_NIM.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class MoviesController : ControllerBase
    {
        private static List<Movie> movies = new List<Movie>
        {
            new Movie
            {
                Title = "The Shawshank Redemption",
                Director = "Frank Darabont",
                Stars = new List<string> { "Tim Robbins", "Morgan Freeman" },
                Description = "Two imprisoned men bond over a number of years..."
            },
            new Movie
            {
                Title = "The Godfather",
                Director = "Francis Ford Coppola",
                Stars = new List<string> { "Marlon Brando", "Al Pacino" },
                Description = "The aging patriarch of an organized crime dynasty transfers control..."
            },
            new Movie
            {
                Title = "The Dark Knight",
                Director = "Christopher Nolan",
                Stars = new List<string> { "Christian Bale", "Heath Ledger" },
                Description = "When the menace known as the Joker wreaks havoc and chaos..."
            }
        };

        [HttpGet]
        public ActionResult<List<Movie>> Get()
        {
            return movies;
        }

        [HttpGet("{id}")]
        public ActionResult<Movie> Get(int id)
        {
            if (id < 0 || id >= movies.Count)
            {
                return NotFound();
            }
            return movies[id];
        }

        [HttpPost]
        public ActionResult<List<Movie>> Post(Movie movie)
        {
            movies.Add(movie);
            return movies;
        }

        [HttpDelete("{id}")]
        public ActionResult<List<Movie>> Delete(int id)
        {
            if (id < 0 || id >= movies.Count)
            {
                return NotFound();
            }
            movies.RemoveAt(id);
            return movies;
        }
    }
}

```
<!-- ====================================================== -->
### Bagian 4: Ini full gambaran solution explorer

<img src="Res_IMG\Jurnal\3_1.png">

<!-- ====================================================== -->
### Bagian 5: Coba Get

<img src="Res_IMG\Jurnal\4.png">

<!-- ====================================================== -->
### Bagian 6: Post atau nambah data

<img src="Res_IMG\Jurnal\5.png">


<!-- ====================================================== -->
### Bagian 7: Get By Index

<img src="Res_IMG\Jurnal\6.png">

<!-- ====================================================== -->
### Bagian 8: Delete
<img src="Res_IMG\Jurnal\7.png">