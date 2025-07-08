# 🕹️ Tic Tac Toe — Java Console Edition

> Tic Tac Toe (a.k.a. X & O) seru untuk dimainkan di terminal!  
> Dibuat dengan bahasa **Java**, berjalan di console, dengan AI komputer sederhana hingga cerdas (Minimax).  
> 🧠 Belajar algoritma + seru-seruan!

---

## 🎨 Screenshot

### Papan permainan:
```
-------------
|   |   |   |
-------------
|   |   |   |
-------------
|   |   |   |
-------------
```

### Saat bermain:
```
Pilih tingkat kesulitan (easy/medium/hard): medium

-------------
| X |   |   |
-------------
|   | O |   |
-------------
|   |   |   |
-------------
Skor: Pemain X = 0 | Komputer O = 0
Pemain X, Masukkan baris dan kolom [0-2]: 
Baris: 0
Kolom: 0

-------------
| X |   | X |
-------------
|   | O |   |
-------------
|   |   | O |
-------------
Komputer menang!
===== Skor saat ini ======
Pemain X: 0
Komputer O: 1
 Restart Game? [y/n]: n
Terimakasih sudah bermain!
```

---

## ✨ Fitur

✅ Papan 3×3 yang tampil jelas di terminal  
✅ Pemain (X) vs Komputer (O)  
✅ 3 tingkat kesulitan:  
🎲 **Easy** — komputer random  
🛡️ **Medium** — komputer bisa block & win  
♟️ **Hard** — komputer optimal dengan **Minimax**  
✅ Deteksi menang & seri otomatis  
✅ Validasi input & pesan error yang ramah  
✅ Bisa restart game setelah selesai

---

## 🚀 Cara Menjalankan

### 📋 Prasyarat
- **Java JDK 8+** sudah terinstal
- Terminal / Command Prompt

### 🔧 Langkah:
1️⃣ Clone repository atau download file `.java`.  
2️⃣ Compile:
```bash
javac -d out src/game/Board.java src/game/Computer.java src/game/Game.java src/game/Score.java src/Main.java
```
3️⃣ Jalankan:
```bash
java -cp out Main
```

---

## 🕹️ Cara Bermain

🎯 Saat giliranmu (X), ketikkan **baris & kolom** yang ingin diisi (angka 0–2).  
Contoh:
```
Pemain X, Masukkan baris dan kolom [0-2]:
Baris: 2
Kolom: 0
```

📋 Baris & kolom dimulai dari 0:
```
(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (2,1) (2,2)
```

🧠 Setelah pemain jalan, komputer otomatis memilih langkahnya.
Game berakhir jika salah satu menang atau papan penuh.

---

## 🧠 Tentang AI Komputer

| Difficulty | Strategi |
|------------|-----------|
| **Easy**   | Random |
| **Medium** | Mencoba menang & block |
| **Hard**   | Selalu optimal dengan Minimax |

---

## 👨‍💻 Kontribusi

💡 Kamu bisa bantu mengembangkan project ini:  
✅ Tambahkan GUI (Swing / JavaFX)  
✅ Tambahkan skor total & leaderboard  
✅ Tambahkan animasi / suara  
✅ Tingkatkan AI lebih cepat dengan alpha-beta pruning

---

### 📥 Cara Kontribusi
1️⃣ Fork repository ini  
2️⃣ Buat branch baru (`git checkout -b fitur-anda`)  
3️⃣ Lakukan perubahan & commit (`git commit -m 'Tambah fitur …'`)  
4️⃣ Push ke branch (`git push origin fitur-anda`)  
5️⃣ Buat Pull Request (PR) ke repo utama

---

## 📜 License

MIT License — bebas digunakan, diubah & dikembangkan.  
Kalau pakai / modifikasi, kasih bintang & mention nama pembuat akan sangat diapresiasi. 🌟

---

## 🙏 Credit

Dibuat dengan ❤️ oleh Muhammad Farhan  
Terinspirasi dari permainan klasik Tic Tac Toe yang tak pernah membosankan.  
Belajar sambil bermain & berbagi ilmu!

---

![Java](https://img.shields.io/badge/Made%20with-Java-blue?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-green?style=flat-square)
