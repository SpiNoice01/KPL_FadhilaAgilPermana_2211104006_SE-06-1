
<div align="center">

# TUGAS PENDAHULUAN  
## KONSTRUKSI PERANGKAT LUNAK  

<img src="https://lac.telkomuniversity.ac.id/wp-content/uploads/2021/01/cropped-1200px-Telkom_University_Logo.svg-270x270.png" width="250px">

### Disusun Oleh:  
**Fadhila Agil Permana** | 2211104006  
**SE-06-01**  

### Asisten Praktikum:  
- Naufal El Kamil Aditya Pratama Rahman  
- Imelda Alfina Palupi Dewi  

### Dosen Pengampu:  
**Yudha Islami Sulistya, S.Kom., M.Cs**  

### PROGRAM STUDI S1 REKAYASA PERANGKAT LUNAK  
### FAKULTAS INFORMATIKA  
### TELKOM UNIVERSITY PURWOKERTO  

<hr>

</div>

---

## Bagian 1: Buat New Project "Blank Solution" dan Penamaan  
<img src="RES_IMG/jurnal/1.png">

---

## Bagian 2: Add New Properties (Library)  
<img src="RES_IMG/jurnal/2.png">

---

## Bagian 3: Cari Library  
<img src="RES_IMG/jurnal/2_1.png">

---

## Bagian 4: Code Library  

```csharp
using System;

namespace MatematikaLibraries
{
    public class Matematika
    {
        public int FPB(int input1, int input2)
        {
            while (input2 != 0)
            {
                int temp = input2;
                input2 = input1 % input2;
                input1 = temp;
            }
            return input1;
        }

        public int KPK(int input1, int input2)
        {
            return (input1 * input2) / FPB(input1, input2);
        }

        public string Turunan(int[] persamaan)
        {
            string hasil = "";
            int pangkat = persamaan.Length - 1;
            for (int i = 0; i < persamaan.Length - 1; i++)
            {
                int koefisien = persamaan[i] * pangkat;
                if (koefisien == 0)
                {
                    pangkat--;
                    continue;
                }

                string tanda = koefisien > 0 && i > 0 ? " + " : (koefisien < 0 ? " - " : "");
                hasil += (i > 0 ? tanda : (koefisien < 0 ? "-" : "")) +
                         Math.Abs(koefisien) +
                         (pangkat - 1 > 0 ? $"x{pangkat - 1}" : (pangkat - 1 == 0 ? "x" : ""));
                pangkat--;
            }
            return hasil;
        }

        public string Integral(int[] persamaan)
        {
            string hasil = "";
            int pangkat = persamaan.Length - 1;
            for (int i = 0; i < persamaan.Length; i++)
            {
                int newPangkat = pangkat + 1;
                double koefisien = (double)persamaan[i] / newPangkat;

                string tanda = koefisien > 0 && i > 0 ? " + " : (koefisien < 0 ? " - " : "");
                hasil += (i > 0 ? tanda : (koefisien < 0 ? "-" : "")) +
                         (Math.Abs(koefisien) == 1 ? "" : Math.Abs(koefisien).ToString("0.#")) +
                         $"x{newPangkat}";
                pangkat--;
            }
            hasil += " + C";
            return hasil;
        }
    }
}
```

---

## Bagian 5: Buat Project Console di dalam Blank Solution  
<img src="RES_IMG/jurnal/3.png">

---

## Bagian 6: Add Reference dari Library yang Dibuat  
<img src="RES_IMG/jurnal/4.png">

---

## Bagian 7: Add Reference dari Library yang Dibuat (Lanjutan)  
<img src="RES_IMG/jurnal/4_1.png">

---

## Bagian 8: Kode Program  

```csharp
using System;
using MatematikaLibraries;

class Program
{
    static void Main()
    {
        Matematika mtk = new Matematika();

        Console.WriteLine("FPB(60, 45) = " + mtk.FPB(60, 45));
        Console.WriteLine("KPK(12, 8) = " + mtk.KPK(12, 8));
        Console.WriteLine("Turunan: " + mtk.Turunan(new int[] { 1, 4, -12, 9 }));
        Console.WriteLine("Integral: " + mtk.Integral(new int[] { 4, 6, -12, 9 }));
    }
}
```

---

## Bagian 9: Output  
<img src="RES_IMG/jurnal/5.png">

---

## Bagian 10: Penjelasan  

1. **FPB(60, 45)**  
   Fungsi ini dieksekusi melalui method berikut:  

   ```csharp
   public int FPB(int a, int b)
   {
       while (b != 0)
       {
           int temp = b;
           b = a % b;
           a = temp;
       }
       return a;
   }
   ```

   Dipanggil dengan:  
   ```csharp
   mtk.FPB(60, 45);
   ```

2. **KPK(12, 8)**  
   Memanggil method berikut:  

   ```csharp
   public int KPK(int a, int b)
   {
       return a * b / FPB(a, b);
   }
   ```

   Dipanggil dengan:  
   ```csharp
   mtk.KPK(12, 8);
   ```

3. **Turunan**  
   Contoh input:  
   ```csharp
   mtk.Turunan(new int[] { 1, 4, -12, 9 });
   ```

   Method di library:  
   ```csharp
   public string Turunan(int[] koef)
   {
       // proses menurunkan tiap suku
   }
   ```

4. **Integral**  
   Contoh input:  
   ```csharp
   mtk.Integral(new int[] { 4, 6, -12, 9 });
   ```

   Method di library:  
   ```csharp
   public string Integral(int[] koef)
   {
       // proses mengintegralkan tiap suku
   }
   ```

