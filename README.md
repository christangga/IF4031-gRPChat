# IF4031-gRPChat
Implementation of IRC-Like Chatting System using Google Protobuf and gRPC framework in Windows

By:
- Christ Angga Saputra - 13512019
- Jeffrey Lingga Binangkit - 13512059

##Petunjuk instalasi/building
1. Ada 2 cara untuk instalasi program ini, yaitu:
  - Clone dari `https://github.com/christangga/IF4031-gRPChat`
  - Ekstrak source code

2. Selanjutnya `Import Project` dengan menggunakan Netbeans

3. Resolve dependencies dengan `Add JAR/Library`, kemudian masukkan semua file yang ada dalam folder `lib/`

##Cara menjalankan program
1. Jalankan `SimpleChatServer.java` dengan klik kanan, pilih `Run File`

2. Jalankan `SimpleChatClient.java` dengan klik kanan, pilih `Run File`. Client dapat dijalankan lebih dari satu

##Daftar tes yang telah dilakukan serta langkah2 melakukan tes

###Mengganti nickname
1. PERSIAPAN
  - Jalankan server
  - Jalankan satu client

2. PENGETESAN
  - Masukkan perintah `/NICK lingga`

3. HASIL
  - Pada client muncul `Successfully changed name to lingga`

###Mengganti nickname yang telah digunakan
1. PERSIAPAN
  - Jalankan server
  - Jalankan dua client

2. PENGETESAN
  - Pada client satu, masukkan perintah `/NICK lingga`
  - Pada client dua, masukkan perintah `/NICK lingga`

3. HASIL
  - Pada client dua muncul `User lingga already exists`

###Melakukan join ke channel PAT
1. PERSIAPAN
  - Jalankan server
  - Jalankan satu client
  - Ubah nickname menjadi christ

2. PENGETESAN
  - Masukkan perintah `/JOIN PAT`

3. HASIL
  - Pada client muncul `Successfully joined channel PAT`

###Melakukan join ke channel PAT yang sudah di-join sebelumnya
1. PERSIAPAN
  - Jalankan server
  - Jalankan satu client
  - Ubah nickname menjadi christ
  - Jalankan `/JOIN PAT`

2. PENGETESAN
  - Masukkan kembali perintah `/JOIN PAT`

3. HASIL
  - Pada client muncul `Already a member of channel PAT`

###Pengetesan leave channel yang diikuti
1. PERSIAPAN
  - Jalankan server
  - Jalankan satu client dengan nick lingga
  - Jalankan perintah `/JOIN PAT`

2. PENGETESAN
  - Jalankan perintah `/LEAVE PAT`

3. HASIL
  - Pada client muncul `Successfully left channel PAT`

###Pengetesan leave channel yang tidak diikuti
1. PERSIAPAN
  - Jalankan server
  - Jalankan dua client dengan nick christ dan lingga
  - Lakukan join ke PAT oleh client christ

2. PENGETESAN
  - Pada client lingga, jalankan perintah `/LEAVE PAT`

3. HASIL
  - Pada client muncul `You are not a member of channel PAT`

###Pengetesan leave channel yang tidak ada
1. PERSIAPAN
  - Jalankan server
  - Jalankan satu client dengan nick lingga

2. PENGETESAN
  - Jalankan perintah `/LEAVE ORKOM`

3. HASIL
  - Pada client muncul `Channel ORKOM not found`

###Pengetesan exit aplikasi
1. PERSIAPAN
  - Jalankan server
  - Jalankan satu client dengan nick lingga

2. PENGETESAN
  - Jalankan perintah `/EXIT`

3. HASIL
  - Pada client muncul `Goodbye, lingga!` kemudian keluar dari program chat

###Pengetesan chatting secara kompleks dimana terdapat dua channel A dan B, dan ada empat client ab, a, b, dan c
1. PERSIAPAN
  - Jalankan server
  - Jalankan empat client dengan nick ab, a, b, dan c
  - Lakukan join ab ke channel A dan channel B
  - Lakukan join a ke channel A
  - Lakukan join b ke channel B
  - Client c tidak join

2. PENGETESAN
  - Pada client ab, masukkan `hai channel A dan B`

3. HASIL
  - Pada client ab, muncul `[A] (ab) hai channel A dan B` dan `[B] (ab) hai channel A dan B`
  - Pada client a, muncul `[A] (ab) hai channel A dan B`
  - Pada client b, muncul `[B] (ab) hai channel A dan B`
  - Pada client c, tidak muncul apa-apa

###Melakukan chatting antara beberapa client dalam satu channel PAT
1. PERSIAPAN
  - Jalankan server
  - Jalankan tiga client dengan nick a, b, dan c
  - Lakukan join ke channel PAT oleh ketiga client tersebut

2. PENGETESAN
  - Pada client a, masukkan `@PAT hai b dan c`

3. HASIL
  - Pada client a, muncul `[PAT] (a) hai b dan c`
  - Pada client b, muncul `[PAT] (a) hai b dan c`
  - Pada client c, muncul `[PAT] (a) hai b dan c`
