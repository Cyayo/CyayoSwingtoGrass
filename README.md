# 🌿 CyayoSwingtoGrass - Seamless Combat System

"Ayunkan senjatamu, tebas musuhmu tanpa rintangan. Serang entitas menembus rumput dan tanaman dekoratif dengan Ray-Tracing presisi."

```text
=========================================
             QUICK TUTORIAL
=========================================
```

### 1. Cara Kerja Plugin
- Plugin ini secara otomatis mendeteksi saat kamu menyerang entitas yang terhalang oleh blok dekoratif (seperti rumput, bunga, dll).
- Kamu tidak perlu menekan tombol khusus, cukup serang seperti biasa.
- Jika ada target valid di balik blok tersebut, seranganmu akan tetap masuk (Ray-Tracing).

### 2. Mengatur Blok yang Dilewati
- Kamu bisa menambahkan atau menghapus jenis blok yang ingin "ditembus" di file `config.yml`.
- Gunakan nama Material Bukkit yang valid (contoh: `GRASS`, `SHORT_GRASS`, `POPPY`).

### 3. Izin Akses (Permissions)
- Pastikan admin memiliki izin `cyayoswing.admin` untuk melakukan konfigurasi ulang lewat command.

```text
=========================================
     CYAYOSWING - COMMANDS & PERMS
=========================================

ADMIN COMMANDS:
/cyayoswing reload          > Reload konfigurasi plugin.
/cyayoswing version         > Cek versi plugin.

PERMISSIONS:
cyayoswing.admin            > Master permission (Akses Semua).
```

### 🚀 Advanced Features
- 🎯 **Ray-Tracing Precision** - Menggunakan algoritma Ray-Tracing yang akurat untuk menentukan apakah ada entitas di jalur serangan pemain.
- 🍃 **Smart Block Bypass** - Hanya melewati blok yang bersifat *passable* atau dekoratif, sehingga tidak menembus dinding atau blok solid.
- ⚡ **Zero Latency** - Dioptimalkan untuk performa tinggi tanpa menyebabkan lag pada server saat banyak pemain bertarung.
- 🛠️ **Fully Customizable** - Kontrol penuh atas daftar blok yang ingin dilewati melalui sistem konfigurasi yang simpel.

---

Made with ❤️ by **Cyayo**
