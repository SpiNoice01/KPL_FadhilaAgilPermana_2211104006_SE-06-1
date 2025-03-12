
<div align="center">
JURNAL <br>
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

</div>
<!-- ====================================================== -->
<hr>
<h2 align="center">KONSTRUKSI PERANGKAT LUNAK</h2>

### Bagian 1, Buat Project Form Dengan Penamaan
<img src="RES_Image\Jurnal\1.png">
<img src="RES_Image\Jurnal\1.2.png">

<!-- ====================================================== -->
### Bagian 2: Github
<img src="RES_Image\Jurnal\2.png">

<!-- ====================================================== -->
### Bagian 3: Kode Generic
<img src="RES_Image\Jurnal\3.png">

```csharp
using System;
using System.Collections.Generic;

// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, World!");

int nimAkhir = 6; // Ganti dengan digit terakhir NIM Anda
dynamic angka1, angka2, angka3;

if (nimAkhir == 1 || nimAkhir == 2)
{
    angka1 = 12f;
    angka2 = 34f;
    angka3 = 56f;
}
else if (nimAkhir == 3 || nimAkhir == 4 || nimAkhir == 5)
{
    angka1 = 12.0;
    angka2 = 34.0;
    angka3 = 56.0;
}
else if (nimAkhir == 6 || nimAkhir == 7 || nimAkhir == 8)
{
    angka1 = 12;
    angka2 = 34;
    angka3 = 56;
}
else
{
    angka1 = 12L;
    angka2 = 34L;
    angka3 = 56L;
}

Penjumlahan penjumlahan = new Penjumlahan();
var hasil = penjumlahan.JumlahTigaAngka(angka1, angka2, angka3);
Console.WriteLine($"Hasil penjumlahan: {hasil}");

SimpleDataBase<dynamic> dataBase = new SimpleDataBase<dynamic>();
dataBase.AddNewData(angka1);
dataBase.AddNewData(angka2);

public class Penjumlahan
{
    public T JumlahTigaAngka<T>(T angka1, T angka2, T angka3)
    {
        dynamic a = angka1;
        dynamic b = angka2;
        dynamic c = angka3;
        return a + b + c;
    }
}

public class SimpleDataBase<T>
{
    private List<T> storedData;
    private List<DateTime> inputDates;

    public SimpleDataBase()
    {
        storedData = new List<T>();
        inputDates = new List<DateTime>();
    }

    public void AddNewData(T data)
    {
        storedData.Add(data);
        inputDates.Add(DateTime.Now);
    }

    public void PrintAllData()
    {
        for (int i = 0; i < storedData.Count; i++)
        {
            Console.WriteLine($"Data {i + 1} berisi: {storedData[i]}, yang disimpan pada waktu UTC: {inputDates[i].ToUniversalTime()}");
        }
    }
}
```

### Bagian 4: Output
<img src="RES_Image\Jurnal\4.png">