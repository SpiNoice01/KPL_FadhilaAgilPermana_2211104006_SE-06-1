1. Long Method (printInfo)
# Refactoring Bad Smells

## 1. Long Method (`printInfo`)
Metode `printInfo` memiliki struktur panjang dengan banyak pengulangan kode (`System.out.println(...)`).  
**Solusi**: Pisahkan logika ke metode kecil yang lebih modular.

---

## 2. Primitive Obsession (`genre`)
`Genre` menggunakan `int` untuk menyatakan tipe lagu dengan angka tetap.  
**Solusi**: Ganti dengan `enum` agar lebih mudah dibaca dan dikelola.

```java
public enum Genre {
    UNDEFINED, POP, ROCK, HIPHOP, RNB, JAZZ, INSTRUMENTALS, CLOWNCORE
}
```

---

## 3. Data Clump (`album` & `artist`)
`Album` dan `Artist` memiliki beberapa atribut yang berkelompok (`albumName`, `albumCoverURL`, `artistName`, dll.).  
**Solusi**: Pisahkan ke dalam kelas terpisah (`Album` dan `Artist`).

```java
public class Album {
    private String name;
    private String coverURL;
}

public class Artist {
    private String name;
    private String alias;
    private String imageURL;
}
```

---

## 4. Feature Envy (`setArtist` & `setAlbum`)
Metode `setArtist` dan `setAlbum` mengatur banyak atribut yang lebih cocok ditangani dalam kelas terpisah (`Album` dan `Artist`).

---

## 5. Null Reference Risk
Tidak ada inisialisasi default untuk `albumName`, `artistName`, dll.  
Jika `printInfo` dipanggil sebelum `setArtist` atau `setAlbum`, bisa terjadi `NullPointerException`.  
**Solusi**: Tambahkan inisialisasi default.

```java
private String artistName = "";
private String albumName = "";
```

---

## 6. Magic Numbers (`detailLevel`)
`detailLevel` menggunakan angka (`0`, `1`, `2`, `3`) tanpa penjelasan yang eksplisit.  
**Solusi**: Gunakan `enum` untuk meningkatkan keterbacaan.

```java
public enum DetailLevel {
    SONG_ONLY, SONG_AND_ARTIST, SONG_AND_ALBUM, FULL_DETAILS
}
```

---

## 7. Perubahan Refactoring

### a. Menggunakan `enum` untuk Genre
**Sebelumnya**: Genre direpresentasikan sebagai angka (`int`), seperti `1 = pop`, `2 = rock`, dst.  
**Masalah**: Membuat kode sulit dibaca dan rentan terhadap kesalahan.  
**Sekarang**: Menggunakan `enum` untuk merepresentasikan genre secara lebih jelas.

```java
public enum Genre {
    UNDEFINED, POP, ROCK, HIP_HOP, RNB, JAZZ, INSTRUMENTALS, CLOWNCORE
}
```

Keuntungan: Lebih mudah dipahami, misalnya `Genre.POP` daripada `1`.

---

### b. Memisahkan `Album` dan `Artist` ke Kelas Terpisah
**Sebelumnya**: Atribut album (`albumName`, `albumCoverURL`) dan artist (`artistName`, `artistAlias`, `artistImageURL`) langsung disimpan dalam kelas `Song`.  
**Masalah**: Jika ingin menambahkan informasi tambahan pada album atau artist, kode `Song` menjadi terlalu besar dan tidak terorganisir.  
**Sekarang**: Dibuat kelas `Album` dan `Artist` sendiri.

```java
public class Album {
    private String name;
    private String coverURL;
}

public class Artist {
    private String name;
    private String alias;
    private String imageURL;
}
```

Keuntungan:  
- `Song` hanya menyimpan referensi ke objek `Album` dan `Artist`, sehingga lebih rapi.  
- Memudahkan pengelolaan informasi album dan artist di masa depan.

---

### c. Menggunakan `enum` untuk Detail Level
**Sebelumnya**: Detail level menggunakan angka (`int`), misalnya `0 = song info only`, `1 = song + artist info`, dst.  
**Masalah**: Sulit diingat dan rawan kesalahan jika tidak ada dokumentasi.  
**Sekarang**: Dibuat `enum` seperti ini:

```java
public enum DetailLevel {
    SONG_ONLY, SONG_AND_ARTIST, SONG_AND_ALBUM, FULL_INFO
}
```

Keuntungan: Lebih jelas, misalnya `DetailLevel.SONG_AND_ARTIST` daripada `1`.

---

### d. Memecah `printInfo` ke Metode Kecil
**Sebelumnya**: `printInfo()` memiliki banyak `if-else`, sehingga sulit dibaca dan dipelihara.  
**Sekarang**: Dibagi menjadi beberapa metode kecil seperti:

```java
private void printBasicInfo() { ... }
private void printArtistInfo() { ... }
private void printAlbumInfo() { ... }
```

Metode `printInfo()` hanya memanggil metode ini berdasarkan `DetailLevel`, sehingga lebih bersih dan mudah dipahami.

---

### e. Menggunakan Null Check
**Sebelumnya**: Langsung mengakses atribut seperti `if (!artistName.equals(""))`, yang bisa menyebabkan error jika `artistName` bernilai `null`.  
**Sekarang**: Menggunakan null check sebelum mengakses atribut:

```java
if (artistName != null && !artistName.isEmpty()) { ... }
```

Keuntungan: Mengurangi risiko aplikasi crash karena `NullPointerException`.