# Spring Kurs Fundamentals

Spring Boot öğrenme sürecinde hazırladığım küçük örnek projeler koleksiyonu. Her klasör bağımsız bir Maven projesidir ve tek bir Spring konusuna odaklanır.

**Teknolojiler:** Java 17 · Spring Boot 4.1.1 · Maven · Spring Web MVC · Spring Data JPA · PostgreSQL · MariaDB

## Projeler

| Proje | Konu | İçerik |
|-------|------|--------|
| [SpringBeanTraining](SpringBeanTraining) | IoC & Bean'ler | `@Configuration`, `@Bean`, bean scope'ları (singleton, prototype, web scope), interface/impl enjeksiyonu |
| [SpringEvents](SpringEvents) | Spring Events | `ApplicationEvent`, `@EventListener`, koşullu listener (`condition`), payload event'leri |
| [SpringAsync](SpringAsync) | Asenkron işlemler | `@Async`, özel `Executor` yapılandırması, async exception handling, async event listener |
| [springRestTraining](springRestTraining) | REST | Controller'lar, header/cookie okuma-yazma, `RestClient` ile GET/POST/PUT/DELETE istemcileri |
| [springORMtraining](springORMtraining) | Spring Data JPA | Entity ilişkileri (Employee–Department), derived query, `@Query`, `Optional`, JSON dönüşü |
| [application](application) · [resource](resource) · [client](client) | Çok servisli uygulama | Katmanlı mimari (presentation/business/data), müşteri-hesap yönetimi, servisler arası HTTP çağrısı |

### application / resource / client

Üç projenin birlikte çalıştığı örnek:

- **resource** (port `8082`): Adres bilgisi sunan basit REST servisi.
- **application**: Müşteri ve hesap CRUD işlemlerini yapan, MariaDB kullanan ana servis. Adres bilgisini `resource` servisinden çeker.
- **client**: `application` servisini tüketen istemci uygulama.

## Gereksinimler

- JDK 17+
- Maven (veya projelerdeki `mvnw`)
- Veritabanı kullanan projeler için:
  - `springORMtraining` → PostgreSQL
  - `application` → MariaDB

## Çalıştırma

```bash
cd <proje-klasörü>
./mvnw spring-boot:run
```

Veritabanı bilgileri koda gömülü değildir, ortam değişkenleriyle verilir:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/ORMtraining
export DB_USERNAME=kullanici
export DB_PASSWORD=sifre
./mvnw spring-boot:run
```

| Değişken | Varsayılan (springORMtraining) | Varsayılan (application) |
|----------|-------------------------------|--------------------------|
| `DB_URL` | `jdbc:postgresql://localhost:5432/ORMtraining` | `jdbc:mariadb://localhost:3306/fundb` |
| `DB_USERNAME` | `postgres` | `root` |
| `DB_PASSWORD` | boş | boş |

Çok servisli örnek için sırayla `resource` → `application` → `client` başlatın. Diğer web projeleri varsayılan olarak `8080` portunu kullanır; aynı anda çalıştırırken `--server.port=XXXX` verin.

## Not

Bu repo eğitim amaçlıdır;
