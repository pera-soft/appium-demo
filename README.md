
# File Otomasyon

Bu proje File yönetim panelinin ve mobil uygulamanın testlerini otomatize etmek amacıyla oluşturulmuştur. 


## Kullanılan Teknolojiler

**Java:** 17

**Spring-Boot:** 4.0.0

**Appium:** 8.3.0

**Selenium:** 4.8.1

**Test-NG:** 7.7.0

  
## Appium Server Kurulum

Appium Server GUI uygulamasını aşağıdaki linkten indirip kurulumunu tamamlayın

```bash
  https://github.com/appium/appium-desktop/releases
```

Uygulamayı başlatın ve Advanced sekmesinde ilgili parametreleri girin ve Start Server ile başlatın.

```bash
  Server Address: 0.0.0.0
  Server Port: 4723

  Allow CORS seçeneğini seçin
```
  
## Projeyi Çalıştırma

Projeyi klonlayın

```bash
  git clone https://link-to-project
```

Proje dizinine gidin

```bash
  cd my-project
```

Gerekli paketleri yükleyin

```bash
  pom.xml dosyasından Maven > Reload Project ile gerekli dependency yüklemelerini başlatın
```

Mobil konfigürasyonlarını tanımlayın

```bash
  src > test > resources altında bulunan mobile.properties dosyasında cihaz ID'sini, platform versiyonunu vb. güncelleyin
```

Web konfigürasyonlarını tanımlayın

```bash
  src > test > resources altında bulunan web.properties dosyasında tarayıcı, username, password vb. güncelleyin
```

Testi çalıştırın

```bash
  src > test > java altında bulunan test senaryolarından birini açın ve run butonuyla çalıştırın.
```