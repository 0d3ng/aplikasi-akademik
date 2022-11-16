# aplikasi-akademik
Contoh webservice rest menggunakan spring boot dengan docker

## Cara menjalankan(Linux)
1. Build image terlebih dahulu menggunakan perintah `docker build -t 0d3ng/komputasi-awan-akademik`, username silakan disesuaikan dengan punya Anda pada docker hub. Pada perintah tersebut username saya adalah `0d3ng`
2. Buat direktori pada `/opt/data/mysql` menggunakan perintah `mkdir /opt/data/mysql`, pastikan folder tersebut bisa ditulis atau tambahkan perintah `chmod -R 775 /opt/data/mysql`
3. Ubah file docker compose pada bagian `image: 0d3ng/komputasi-awan-akademik`, sesuaikan dengan `image: [username Anda]/komputasi-awan-akademik`
4. Jalankan perintah `docker-compose up`

## Cara menjalankan(Windows)
1. Khusus untuk langkah no.2 ditiadakan ketika menjalankan menggunakan dengan Linux
2. Hapus tag `volumes:` yang nilainya `/opt/data/mysql:/var/lib/mysql` dan `~/.m2:/root/.m2`
3. Atau langsung clone repo ini dengan branch `cloud-docker-windows`
