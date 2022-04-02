CREATE TABLE IF NOT EXISTS `book`
(
    `id`               BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    `user_id`          BIGINT UNSIGNED  NOT NULL COMMENT '作者 id',
    `book_category_id` BIGINT UNSIGNED  NULL COMMENT '書本分類 id',
    `title`            VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '書本標題',
    `price_type`       TINYINT UNSIGNED NOT NULL DEFAULT 2 COMMENT '免費or付費閱讀，1-免費, 2-付費，預設為 2',
    `price`            DECIMAL(10, 2)   NOT NULL DEFAULT 0.00 COMMENT '書本售價',
    `synopsis`         VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '書本簡介',
    `acquisition`      VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '你能學到',
    `cover`            VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '書封',
    `published_at`     DATETIME         NULL COMMENT '出版日期',
    `status`           TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '上架狀態，0-未上架，1-已上架，預設為 0',
    `character_count`  INT              NOT NULL DEFAULT 0 COMMENT '總字數',
    `is_deleted`       TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否刪除，0-未刪除，1-刪除，預設為 0',
    `created_at`       DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`       DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `book_category`
(
    `id`            BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    `title`         VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '書本分類名稱',
    `sort_position` INT              NOT NULL DEFAULT 0 COMMENT '排序位置',
    `is_deleted`    TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否刪除，0-未刪除，1-刪除，預設為 0',
    `created_at`    DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`    DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `chapter`
(
    `id`            BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    `book_id`       BIGINT UNSIGNED  NOT NULL COMMENT '書本 id',
    `title`         VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '章節名稱',
    `sort_position` INT              NOT NULL DEFAULT 0 COMMENT '排序位置',
    `is_deleted`    TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否刪除，0-未刪除，1-刪除，預設為 0',
    `created_at`    DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`    DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `page`
(
    `id`              BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    `chapter_id`      BIGINT UNSIGNED  NOT NULL COMMENT '章節 id',
    `title`           VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '頁面標題',
    `body`            TEXT             NULL COMMENT '頁面內容',
    `character_count` INT              NOT NULL DEFAULT 0 COMMENT '字數',
    `sort_position`   INT              NOT NULL DEFAULT 0 COMMENT '排序位置',
    `is_deleted`      TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否刪除，0-未刪除，1-刪除，預設為 0',
    `created_at`      DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`      DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS `book_review`
(
    `id`          BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    `comment`     VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '留言內容',
    `user_id`     BIGINT UNSIGNED  NOT NULL COMMENT '使用者 id',
    `book_id`     BIGINT UNSIGNED  NOT NULL COMMENT '書本   id',
    `rating_star` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '評分 0 ~ 5',
    `is_deleted`  TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否刪除，0-未刪除，1-刪除，預設為 0',
    `created_at`  DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`  DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `user`
(
    `id`         BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '使用者名稱',
    `uid`        VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '使用者 Uid',
    `password`   VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '使用者密碼',
    `email`      VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '使用者 E-mail',
    `avatar`     VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '使用者頭像',
    `short_bio`  VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '使用者簡短介紹',
    `full_bio`   VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '使用者完整介紹',
    `birthday`   DATE             NULL COMMENT '使用者生日',
    `is_author`  TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否是作者，0-否，1-是，預設為 0',
    `twitter`    VARCHAR(255)     NOT NULL DEFAULT '',
    `github`     VARCHAR(255)     NOT NULL DEFAULT '',
    `linkedin`   VARCHAR(255)     NOT NULL DEFAULT '',
    `facebook`   VARCHAR(255)     NOT NULL DEFAULT '',
    `is_blocked` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否停權，0-否，1-是，預設為 0',
    `is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否刪除，0-未刪除，1-刪除，預設為 0',
    `created_at` DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at` DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id),
    CONSTRAINT uk_uid UNIQUE (uid),
    CONSTRAINT uk_email UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS `user_bookshelf`
(
    `id`              BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    `user_id`         BIGINT UNSIGNED  NOT NULL COMMENT '使用者 id',
    `book_id`         BIGINT UNSIGNED  NOT NULL COMMENT '書本 id',
    `last_chapter_id` BIGINT UNSIGNED  NOT NULL COMMENT '上次閱讀章節 id',
    `is_deleted`      TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否刪除，0-未刪除，1-刪除，預設為 0',
    `created_at`      DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`      DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `cart`
(
    `id`              BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `code`            VARCHAR(255)    NOT NULL DEFAULT '' COMMENT '購物車編號',
    `subtotal`        DECIMAL(10, 2)  NOT NULL DEFAULT 0 COMMENT '購物車小計',
    `total_price`     DECIMAL(10, 2)  NOT NULL DEFAULT 0 COMMENT '購物車總金額',
    `total_discounts` DECIMAL(10, 2)  NOT NULL DEFAULT 0 COMMENT '購物車總折扣',
    `user_id`         BIGINT UNSIGNED NOT NULL COMMENT '使用者 id',
    `created_at`      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id),
    CONSTRAINT uk_cart_code UNIQUE (code)
);

CREATE TABLE IF NOT EXISTS `cart_line_item`
(
    `id`              BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `cart_id`         BIGINT UNSIGNED NOT NULL COMMENT '購物車 id',
    `name`            VARCHAR(255)    NOT NULL DEFAULT '' COMMENT '商品名稱',
    `price`           DECIMAL(10, 2)  NOT NULL DEFAULT 0 COMMENT '商品金額',
    `quantity`        INT             NOT NULL DEFAULT 1,
    `subtotal`        DECIMAL(10, 2)  NOT NULL DEFAULT 0 COMMENT '商品小計',
    `total_discounts` DECIMAL(10, 2)  NOT NULL DEFAULT 0 COMMENT '商品總折扣',
    `total_price`     DECIMAL(10, 2)  NOT NULL DEFAULT 0 COMMENT '商品總金額',
    `created_at`      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `order`
(
    `id`              BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    `user_id`         BIGINT UNSIGNED  NOT NULL COMMENT '購買人 id',
    `invoice_id`      BIGINT UNSIGNED  NULL COMMENT '發票 id',
    `code`            VARCHAR(255)     NOT NULL COMMENT '訂單編號',
    `order_status`    TINYINT UNSIGNED NOT NULL COMMENT '訂單狀態',
    `subtotal`        DECIMAL(10, 2)   NOT NULL DEFAULT 0 COMMENT '訂單小計',
    `total_discounts` DECIMAL(10, 2)   NOT NULL DEFAULT 0 COMMENT '訂單總折扣',
    `total_price`     DECIMAL(10, 2)   NOT NULL DEFAULT 0 COMMENT '訂單總金額',
    `payment_mode_id` BIGINT UNSIGNED  NOT NULL COMMENT '付款方式',
    `payment_status`  TINYINT UNSIGNED NOT NULL COMMENT '付款狀態',
    `pay_at`          DATETIME         NOT NULL COMMENT '付款時間',
    `complete_at`     DATETIME         NOT NULL COMMENT '訂單完成時間',
    `is_deleted`      TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '訂單禁止刪除',
    `created_at`      DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`      DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id),
    CONSTRAINT uk_order_code UNIQUE (code)
);

CREATE TABLE IF NOT EXISTS `order_line_item`
(
    `id`              BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    `order_id`        BIGINT UNSIGNED  NOT NULL,
    `book_id`         BIGINT UNSIGNED  NOT NULL,
    `name`            VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '商品名稱',
    `price`           DECIMAL(10, 2)   NOT NULL DEFAULT 0 COMMENT '商品金額',
    `quantity`        INT              NOT NULL DEFAULT 1,
    `subtotal`        DECIMAL(10, 2)   NOT NULL DEFAULT 0 COMMENT '商品小計',
    `total_discounts` DECIMAL(10, 2)   NOT NULL DEFAULT 0 COMMENT '商品總折扣',
    `total_price`     DECIMAL(10, 2)   NOT NULL DEFAULT 0 COMMENT '商品總金額',
    `is_deleted`      TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '訂單商品禁止刪除',
    `created_at`      DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`      DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `payment_mode`
(
    `id`          BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    `code`        VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '付款識別子',
    `description` VARCHAR(255)     NOT NULL DEFAULT '' COMMENT '付款方式描述',
    `is_active`   TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否啟用，0-未啟用，1-啟用，預設為 1',
    `is_deleted`  TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否刪除，0-未刪除，1-刪除，預設為 0',
    `created_at`  DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
    `updated_at`  DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改時間',
    PRIMARY KEY (id),
    CONSTRAINT uk_payment_mode_code UNIQUE (code)
);
