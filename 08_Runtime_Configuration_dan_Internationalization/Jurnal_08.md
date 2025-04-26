
<div align="center">

# TUGAS PENDAHULUAN  
## KONSTRUKSI PERANGKAT LUNAK  

<img src="https://lac.telkomuniversity.ac.id/wp-content/uploads/2021/01/cropped-1200px-Telkom_University_Logo.svg-270x270.png" width="250px">

**Disusun Oleh:**  
Fadhila Agil Permana | 2211104006  
SE-06-01  

**Asisten Praktikum:**  
- Naufal El Kamil Aditya Pratama Rahman  
- Imelda Alfina Palupi Dewi  

**Dosen Pengampu:**  
Yudha Islami Sulistya, S.Kom., M.Cs  

**PROGRAM STUDI S1 REKAYASA PERANGKAT LUNAK**  
**FAKULTAS INFORMATIKA**  
**TELKOM UNIVERSITY PURWOKERTO**  

<hr>

</div>

---

### Bagian 1: Buat Console dan Penamaan
![Bagian 1](RES_IMG/Jurnal/1.png)

---

### Bagian 2: Instal NuGet
![Bagian 2](RES_IMG/TP/2.png)

---

### Bagian 3: Add New File
![Bagian 3](RES_IMG/Jurnal/2.png)

---

### Bagian 4: Tambahkan JSON
![Bagian 4](RES_IMG/Jurnal/3.png)

---

### Bagian 5: Codenya

#### Program.cs
```csharp
using System;

class Program
{
    static void Main(string[] args)
    {
        BankTransferConfig config = BankTransferConfig.LoadConfig();

        if (config.lang == "en")
        {
            Console.WriteLine("Please insert the amount of money to transfer:");
        }
        else
        {
            Console.WriteLine("Masukkan jumlah uang yang akan di-transfer:");
        }

        long amount = long.Parse(Console.ReadLine());
        long fee = (amount <= config.transfer.threshold) ? config.transfer.low_fee : config.transfer.high_fee;
        long total = amount + fee;

        if (config.lang == "en")
        {
            Console.WriteLine($"Transfer fee = {fee}");
            Console.WriteLine($"Total amount = {total}");
            Console.WriteLine("Select transfer method:");
        }
        else
        {
            Console.WriteLine($"Biaya transfer = {fee}");
            Console.WriteLine($"Total biaya = {total}");
            Console.WriteLine("Pilih metode transfer:");
        }

        for (int i = 0; i < config.methods.Count; i++)
        {
            Console.WriteLine($"{i + 1}. {config.methods[i]}");
        }

        int methodChoice = int.Parse(Console.ReadLine());

        if (config.lang == "en")
        {
            Console.WriteLine($"Please type \"{config.confirmation.en}\" to confirm the transaction:");
        }
        else
        {
            Console.WriteLine($"Ketik \"{config.confirmation.id}\" untuk mengkonfirmasi transaksi:");
        }

        string confirmationInput = Console.ReadLine();

        bool confirmed = (config.lang == "en" && confirmationInput == config.confirmation.en) ||
                         (config.lang == "id" && confirmationInput == config.confirmation.id);

        if (confirmed)
        {
            if (config.lang == "en")
            {
                Console.WriteLine("The transfer is completed");
            }
            else
            {
                Console.WriteLine("Proses transfer berhasil");
            }
        }
        else
        {
            if (config.lang == "en")
            {
                Console.WriteLine("Transfer is cancelled");
            }
            else
            {
                Console.WriteLine("Transfer dibatalkan");
            }
        }
    }
}
```

#### BankTransferConfig.cs
```csharp
using System;
using System.Collections.Generic;
using System.IO;
using Newtonsoft.Json;

public class BankTransferConfig
{
    public required string lang { get; set; }
    public required Transfer transfer { get; set; }
    public required List<string> methods { get; set; }
    public required Confirmation confirmation { get; set; }

    public class Transfer
    {
        public long threshold { get; set; }
        public long low_fee { get; set; }
        public long high_fee { get; set; }
    }

    public class Confirmation
    {
        public required string en { get; set; }
        public required string id { get; set; }
    }

    private static string configFilePath = "bank_transfer_config.json";

    public static BankTransferConfig LoadConfig()
    {
        if (!File.Exists(configFilePath))
        {
            BankTransferConfig defaultConfig = CreateDefaultConfig();
            SaveConfig(defaultConfig);
            return defaultConfig;
        }
        else
        {
            string json = File.ReadAllText(configFilePath);
            return JsonConvert.DeserializeObject<BankTransferConfig>(json)
                   ?? throw new InvalidOperationException("Failed to deserialize configuration.");
        }
    }

    public static void SaveConfig(BankTransferConfig config)
    {
        string json = JsonConvert.SerializeObject(config, Formatting.Indented);
        File.WriteAllText(configFilePath, json);
    }

    private static BankTransferConfig CreateDefaultConfig()
    {
        return new BankTransferConfig
        {
            lang = "en",
            transfer = new Transfer
            {
                threshold = 25000000,
                low_fee = 6500,
                high_fee = 15000
            },
            methods = new List<string> { "RTO (real-time)", "SKN", "RTGS", "BI FAST" },
            confirmation = new Confirmation
            {
                en = "yes",
                id = "ya"
            }
        };
    }
}
```

---

### Bagian 6: Output
![Bagian 6](RES_IMG/Jurnal/4.png)
