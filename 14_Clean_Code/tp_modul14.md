
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

### KONSTRUKSI PERANGKAT LUNAK

<hr>

### Bagian 1, Buat Console Dan Penamaan
<img src="IMAGE\tp\1.png">

<!-- ====================================================== -->
### Bagian 2: Bikin Class Baru
```csharp
public class SayaTubeUser
{
    public int Id { get; private set; }
    public List<SayaTubeVideo> UploadedVideos { get; private set; }
    public string Username { get; private set; }

    public SayaTubeUser(string username)
    {
        Random random = new Random();
        this.Id = random.Next(10000, 99999);
        this.Username = username;
        this.UploadedVideos = new List<SayaTubeVideo>();
    }

    public int GetTotalVideoPlayCount()
    {
        int totalPlayCount = 0;
        foreach (var video in UploadedVideos)
        {
            totalPlayCount += video.PlayCount;
        }
        return totalPlayCount;
    }

    public void AddVideo(SayaTubeVideo video)
    {
        UploadedVideos.Add(video);
    }

    public void PrintAllVideoPlaycount()
    {
        Console.WriteLine($"User: {Username}");
        for (int i = 0; i < UploadedVideos.Count; i++)
        {
            Console.WriteLine($"Video {i + 1} judul: {UploadedVideos[i].Title}");
        }
    }
}
```

```csharp
public class SayaTubeVideo
{
    public int Id { get; private set; }
    public string Title { get; private set; }
    public int PlayCount { get; private set; }

    public SayaTubeVideo(string title)
    {
        Random random = new Random();
        this.Id = random.Next(10000, 99999);
        this.Title = title;
        this.PlayCount = 0;
    }

    public void IncreasePlayCount(int count)
    {
        this.PlayCount += count;
    }

    public void PrintVideoDetails()
    {
        Console.WriteLine($"ID: {Id}");
        Console.WriteLine($"Title: {Title}");
        Console.WriteLine($"PlayCount: {PlayCount}");
    }
}
```

<!-- ====================================================== -->
### Bagian 3: Bikin Fungsi & Full Code
```csharp
using System;
using System.Collections.Generic;
using System.Diagnostics.Contracts;

public class SayaTubeUser
{
    public int Id { get; private set; }
    public List<SayaTubeVideo> UploadedVideos { get; private set; }
    public string Username { get; private set; }

    public SayaTubeUser(string username)
    {
        Contract.Requires(username != null, "Username tidak boleh null");
        Contract.Requires(username.Length <= 100, "Panjang username maksimal 100 karakter");

        Random random = new Random();
        this.Id = random.Next(10000, 99999);
        this.Username = username;
        this.UploadedVideos = new List<SayaTubeVideo>();
    }

    public int GetTotalVideoPlayCount()
    {
        int totalPlayCount = 0;
        foreach (var video in UploadedVideos)
        {
            totalPlayCount += video.PlayCount;
        }
        return totalPlayCount;
    }

    public void AddVideo(SayaTubeVideo video)
    {
        Contract.Requires(video != null, "Video tidak boleh null");
        Contract.Requires(video.PlayCount < int.MaxValue, "PlayCount video harus kurang dari integer maksimum");

        UploadedVideos.Add(video);
    }

    public void PrintAllVideoPlaycount()
    {
        Console.WriteLine($"User: {Username}");
        for (int i = 0; i < Math.Min(UploadedVideos.Count, 8); i++)
        {
            Console.WriteLine($"Video {i + 1} judul: {UploadedVideos[i].Title}");
        }
    }
}

public class SayaTubeVideo
{
    public int Id { get; private set; }
    public string Title { get; private set; }
    public int PlayCount { get; private set; }

    public SayaTubeVideo(string title)
    {
        Contract.Requires(title != null, "Judul video tidak boleh null");
        Contract.Requires(title.Length <= 200, "Panjang judul video maksimal 200 karakter");

        Random random = new Random();
        this.Id = random.Next(10000, 99999);
        this.Title = title;
        this.PlayCount = 0;
    }

    public void IncreasePlayCount(int count)
    {
        Contract.Requires(count <= 25000000, "Penambahan play count maksimal 25.000.000 per panggilan");
        Contract.Requires(count >= 0, "Play count tidak boleh negatif");

        checked
        {
            try
            {
                this.PlayCount += count;
            }
            catch (OverflowException)
            {
                Console.WriteLine("Terjadi overflow pada penambahan play count");
            }
        }
    }

    public void PrintVideoDetails()
    {
        Console.WriteLine($"ID: {Id}");
        Console.WriteLine($"Title: {Title}");
        Console.WriteLine($"PlayCount: {PlayCount}");
    }
}

class Program
{
    static void Main(string[] args)
    {
        SayaTubeUser user = new SayaTubeUser("Agil");

        string[] videoTitles = {
            "TaxiDriver",
            "Drive",
            "You're never really here",
            "American Pyscho",
            "Fight Club",
            "Falling Down",
            "First Reformed",
            "The King of Comedy",
            "The Dark Knight",
            "The Dark Knight Rises"
        };

        foreach (var title in videoTitles)
        {
            SayaTubeVideo video = new SayaTubeVideo(title);
            user.AddVideo(video);
        }

        user.PrintAllVideoPlaycount();

        Console.WriteLine();
        Console.WriteLine("===== REVIEW");
        Console.WriteLine();

        SayaTubeUser reviewUser = new SayaTubeUser("Agil");

        foreach (var title in videoTitles)
        {
            SayaTubeVideo video = new SayaTubeVideo($"Review Film {title} oleh Agil");
            reviewUser.AddVideo(video);
        }

        reviewUser.PrintAllVideoPlaycount();

        // Testing preconditions, exceptions, and postconditions
        try
        {
            SayaTubeVideo invalidVideo = new SayaTubeVideo(null); // Should throw exception
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }

        try
        {
            SayaTubeUser invalidUser = new SayaTubeUser(null); // Should throw exception
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }

        SayaTubeVideo testVideo = new SayaTubeVideo("Test Video");
        try
        {
            testVideo.IncreasePlayCount(30000000); // Should throw exception
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }

        try
        {
            testVideo.IncreasePlayCount(-1); // Should throw exception
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }

        // Testing overflow
        try
        {
            for (int i = 0; i < 10; i++)
            {
                testVideo.IncreasePlayCount(int.MaxValue / 10);
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }
    }
}

```

<!-- ====================================================== -->
### Bagian 4: Output
<img src="IMAGE\tp\4.png">