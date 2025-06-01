
<div align="center">

# TUGAS PENDAHULUAN  
## KONSTRUKSI PERANGKAT LUNAK  

<img src="https://lac.telkomuniversity.ac.id/wp-content/uploads/2021/01/cropped-1200px-Telkom_University_Logo.svg-270x270.png" width="250px">

### Disusun Oleh:  
**Fadhila Agil Permana** | 2211104006  
**SE-06-01**  

### Asisten Praktikum:  
- **Naufal El Kamil Aditya Pratama Rahman**  
- **Imelda Alfina Palupi Dewi**  

### Dosen Pengampu:  
**Yudha Islami Sulistya, S.Kom., M.Cs**  

### PROGRAM STUDI S1 REKAYASA PERANGKAT LUNAK  
### FAKULTAS INFORMATIKA  
### TELKOM UNIVERSITY PURWOKERTO  

<hr>

</div>

---

## Bagian 1: Menjelaskan Salah Satu Design Pattern

Buka halaman web [Refactoring Guru - Design Patterns Catalog](https://refactoring.guru/design-patterns/catalog) kemudian baca design pattern dengan nama **Observer**, dan jawab pertanyaan berikut ini (dalam Bahasa Indonesia):

---

### **A. Contoh Penggunaan Design Pattern Observer**

Observer pattern cocok digunakan pada situasi di mana suatu objek (**subject**) harus memberitahu objek-objek lain (**observer**) ketika terjadi perubahan.

**Contoh:**  
Aplikasi cuaca: Jika data suhu berubah, semua tampilan (widget) yang menampilkan suhu harus diperbarui secara otomatis.

---

### **B. Langkah-Langkah Implementasi Design Pattern Observer**

1. **Buat Interface Observer**  
    Berisi metode untuk menerima notifikasi, seperti `Update()`.

2. **Buat Interface Subject**  
    Berisi metode untuk:  
    - Mendaftarkan observer.  
    - Menghapus observer.  
    - Memberi notifikasi ke observer.

3. **Buat ConcreteSubject**  
    - Menyimpan data.  
    - Memanggil `Notify()` untuk memberi tahu observer jika terjadi perubahan.

4. **Buat ConcreteObserver**  
    - Mengimplementasikan metode `Update()`.  
    - Bereaksi terhadap perubahan yang diberitahukan oleh subject.

---

### **C. Kelebihan dan Kekurangan Design Pattern Observer**

#### **Kelebihan:**
- **Loose coupling** antara subject dan observer.  
- Mudah menambah observer baru tanpa mengubah subject.  
- Cocok untuk **event-driven programming**.

#### **Kekurangan:**
- Urutan notifikasi ke observer tidak dijamin.  
- Sulit untuk debugging jika banyak observer saling terkait.  
- Jika observer terlalu banyak, dapat menyebabkan penurunan performa.

---

## Bagian 2: BUAT Console App
<p align="center">
  <img src="IMAGE/TP/1.png" alt="Bagian 2">
</p>

---

## Bagian 2 Part 2: SETUP
<p align="center">
  <img src="IMAGE/TP/2.png" alt="Bagian 2 Part 2">
</p>

---

## Bagian 3: Code

```csharp
using System;
using System.Collections.Generic;

// Subject
public interface ISubject
{
     void Attach(IObserver observer);
     void Detach(IObserver observer);
     void Notify();
}

public class WeatherStation : ISubject
{
     private List<IObserver> observers = new List<IObserver>();
     private int temperature;

     public void Attach(IObserver observer)
     {
          observers.Add(observer);
     }

     public void Detach(IObserver observer)
     {
          observers.Remove(observer);
     }

     public void Notify()
     {
          foreach (var observer in observers)
          {
                observer.Update(temperature);
          }
     }

     public void SetTemperature(int temp)
     {
          Console.WriteLine($"\n[WeatherStation] Suhu berubah menjadi {temp}°C");
          temperature = temp;
          Notify();
     }
}

// Observer
public interface IObserver
{
     void Update(int temperature);
}

public class PhoneDisplay : IObserver
{
     public void Update(int temperature)
     {
          Console.WriteLine($"[PhoneDisplay] Menampilkan suhu: {temperature}°C");
     }
}

public class WindowDisplay : IObserver
{
     public void Update(int temperature)
     {
          Console.WriteLine($"[WindowDisplay] Menampilkan suhu: {temperature}°C");
     }
}

// Main program
class Program
{
     static void Main(string[] args)
     {
          var weatherStation = new WeatherStation();

          var phoneDisplay = new PhoneDisplay();
          var windowDisplay = new WindowDisplay();

          weatherStation.Attach(phoneDisplay);
          weatherStation.Attach(windowDisplay);

          weatherStation.SetTemperature(25);
          weatherStation.SetTemperature(30);

          weatherStation.Detach(windowDisplay);

          weatherStation.SetTemperature(20);
     }
}
```

---

## Bagian 4: RUN
<p align="center">
  <img src="IMAGE/TP/3.png" alt="Bagian 4">
</p>
