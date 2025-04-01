CREATE TABLE IF NOT EXISTS "Customer" (
    "customer_id" INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "name" VARCHAR(100) NOT NULL,
    "email" VARCHAR(100) NOT NULL,
    "mobile_number" VARCHAR(100) NOT NULL,
    "created_at" DATE NOT NULL,
    "created_by" VARCHAR(20) NOT NULL,
    "updated_at" DATE DEFAULT NULL,
    "updated_by" VARCHAR(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS "Accounts" (
    "account_number" INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "customer_id" INT NOT NULL,
    "account_type" VARCHAR(100) NOT NULL,
    "mobile_number" VARCHAR(100) NOT NULL,
    "branch_address" VARCHAR(200) NOT NULL,
    "created_at" DATE NOT NULL,
    "created_by" VARCHAR(20) NOT NULL,
    "updated_at" DATE DEFAULT NULL,
    "updated_by" VARCHAR(20) DEFAULT NULL,
    FOREIGN KEY ("customer_id") REFERENCES "Customer"("customer_id") ON DELETE CASCADE
);
