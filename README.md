# Spring Boot Fundamentals Training

Spring Boot kursu sırasında yaptığım alıştırmalar. Her klasör ayrı bir Maven projesi (Java 17, Spring Boot).

- **SpringBeanTraining** – bean ve scope'lar
- **SpringEvents** – event ve listener
- **SpringAsync** – `@Async` ve executor
- **springRestTraining** – REST controller ve client örnekleri
- **springORMtraining** – Spring Data JPA (PostgreSQL)
- **application / resource / client** – birbiriyle konuşan servisler (`application` MariaDB kullanır)

Çalıştırmak için proje klasöründe `./mvnw spring-boot:run`. Veritabanı kullanan projeler için `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` ortam değişkenlerini ayarlamak gerekir.
