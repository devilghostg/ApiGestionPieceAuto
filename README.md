# 🚗 API REST - Gestion de Pièces Automobiles

Ce projet est une API REST développée avec **Spring Boot** qui permet de gérer des pièces automobiles, des véhicules et des fournisseurs. Elle respecte les consignes suivantes :

- 5 entités minimum
- Une relation d’**agrégation/composition**
- Une relation d’**héritage**
- CRUD complet pour chaque entité
- Documentation automatique via **Swagger (OpenAPI)**

---

## 📌 Objectifs pédagogiques

- Pratique de la modélisation objet (héritage, relations)
- Mise en œuvre de Spring Boot pour créer une API REST
- Gestion des dépendances avec Maven
- Utilisation de Swagger pour documenter l’API

---

## 📦 Entités principales

### 1. `PieceAuto` *(abstraite)*
Classe de base pour les pièces, avec des attributs communs :
- `id`
- `reference`
- `nom`
- `marque`
- `prix`

### 2. `PieceMoteur` *(hérite de `PieceAuto`)*
- `puissance`
- `typeMoteur`

### 3. `PieceCarrosserie` *(hérite de `PieceAuto`)*
- `typeCarrosserie`
- `couleur`

### 4. `Vehicule`
- `id`
- `marque`
- `modele`
- `annee`
- `immatriculation`
- **Relation** : possède plusieurs `PieceAuto` (composition)

### 5. `Fournisseur`
- `id`
- `nom`
- `adresse`
- `telephone`
- **Relation** : un fournisseur fournit plusieurs `PieceAuto`

---

## 🔄 Relations

- **Héritage** : `PieceMoteur` et `PieceCarrosserie` héritent de `PieceAuto`
- **Composition** : un `Vehicule` est composé de plusieurs `PieceAuto`
- **ManyToOne** : chaque `PieceAuto` est liée à un `Fournisseur`
- **ManyToMany** *(optionnelle)* : les `PieceAuto` peuvent être associées à plusieurs `Vehicule`

---

## 🛠️ Technologies utilisées

- Java 17+
- Spring Boot 3.x
- Maven
- Spring Data JPA
- H2 (base de données en mémoire)
- Swagger / Springdoc OpenAPI

---

## 🚀 Lancer le projet

### Prérequis

- JDK 17 ou supérieur
- Maven

Démarrage

```bash
git clone https://github.com/ton-utilisateur/garage-api.git
cd garage-api
mvn spring-boot:run