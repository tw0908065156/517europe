create databse europe;

use europe;

CREATE TABLE t_client(
  client_id INT AUTO_INCREMENT COMMENT '用戶id',
  client_email VARCHAR(30) UNIQUE NOT NULL COMMENT '電子郵箱(登錄帳號)',
  client_password CHAR(32) NOT NULL COMMENT '密碼',
  ps_salt CHAR(36) COMMENT '密碼加密鹽值',
  client_nickname VARCHAR(20) COMMENT '名字或暱稱',
  client_phone VARCHAR(20) COMMENT '聯絡電話',
  client_gender INT COMMENT '稱謂:0-未選擇，1-先生，2-女士，3-小姐，4-太太，5-同學',
  is_delete INT COMMENT '是否標記為刪除:0-未刪除，1-已刪除',
  created_user VARCHAR(30) COMMENT '創建人',
  created_time DATETIME COMMENT '創建時間',
  modified_user VARCHAR(30) COMMENT '最後修改人',
  modified_time DATETIME COMMENT '最後修改時間',
  PRIMARY KEY (client_id)
)DEFAULT CHARSET=UTF8;


CREATE TABLE t_category (caid INT AUTO_INCREMENT COMMENT '景點類型id',
scenic_category VARCHAR(30) COMMENT '景點類型',
PRIMARY KEY (caid)
) DEFAULT CHARSET=UTF8;


CREATE TABLE t_country (cid INT AUTO_INCREMENT COMMENT '國家id',
ccode CHAR(4) COMMENT '國家代碼', 
cname VARCHAR(30) COMMENT '國家名', 
cpriority INT COMMENT '國家顯示優先級(0-不顯示，數字越大優先級越高)', 
country_image VARCHAR(50) COMMENT '代表圖片', 
PRIMARY KEY (cid)
) DEFAULT CHARSET=UTF8;


CREATE TABLE t_scenic (sid INT AUTO_INCREMENT COMMENT '景點id',
ccode CHAR(4) COMMENT '國家代碼', 
cname VARCHAR(30) COMMENT '國家名', 
tcode CHAR(3) COMMENT '城市/區域代碼', 
tname VARCHAR(30) COMMENT '城市/區域名', 
tpriority INT COMMENT '城市/區域優先級(0-不顯示，數字越大優先級越高)', 
scenic VARCHAR(50) COMMENT '景點名稱', 
unesco VARCHAR(20) COMMENT '世界遺產', 
sticket INT COMMENT '門票', 
stime VARCHAR(20) COMMENT '參觀時間', 
highlights VARCHAR(100) COMMENT '特色/亮點', 
scenic_wiki VARCHAR(200) COMMENT '景點詳細介紹', 
spriority INT COMMENT '景點優先級(0-不顯示，數字越大優先級越高)', 
scode VARCHAR(12) COMMENT '景點代碼',
hotel_weights double(3,2) comment '飯店權重',
bus_weights double(3,2) comment'車資權重',
PRIMARY KEY (sid)
) DEFAULT CHARSET=UTF8;


CREATE TABLE t_scart (cartid INT AUTO_INCREMENT COMMENT '選購項目id',
client_email VARCHAR(30) COMMENT '用戶email',
sid INT COMMENT '景點id',
scode VARCHAR(12) COMMENT '景點代碼',
created_user VARCHAR(30) COMMENT '創建人',
created_time DATETIME COMMENT '創建時間',
modified_user VARCHAR(30) COMMENT '最後修改人',
modified_time DATETIME COMMENT '最後修改時間',
PRIMARY KEY (cartid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_hotel (hid INT AUTO_INCREMENT COMMENT '飯店類型id',
hotel_grade VARCHAR(20) COMMENT '飯店等級',
hotel_details VARCHAR(100) COMMENT '飯店描述',
hpriority INT COMMENT '顯示優先級(0-不顯示，數字越大優先級越高)',
hotel_fare INT COMMENT '基準價格',
PRIMARY KEY (hid)
) DEFAULT CHARSET=UTF8;


CREATE TABLE t_travel_days (daysid INT AUTO_INCREMENT COMMENT '旅遊天數id',
travel_days VARCHAR(10) COMMENT '旅遊天數',
stay_nights INT COMMENT '住宿晚數',
dpriority INT COMMENT '顯示優先級(0-不顯示，數字越大優先級越高)',
PRIMARY KEY (daysid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_person_bus
 (personid INT AUTO_INCREMENT COMMENT '人數id',
total_person VARCHAR(10) COMMENT '人數顯示',
person_number INT COMMENT '實際人數',
bus_model VARCHAR(30) COMMENT '車型',
bus_fare INT COMMENT '每日車資',
driver_tip INT COMMENT '司機費用',
person_fare INT COMMENT '人均每日車資',
ppriority INT COMMENT '顯示優先級(0-不顯示，數字越大優先級越高)',
PRIMARY KEY (personid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_flights_type
 (flightsid INT AUTO_INCREMENT COMMENT '航班id',
flights_type VARCHAR(20) COMMENT '航空公司',
flights_code VARCHAR(10) COMMENT '航空代碼',
transfer_type VARCHAR(60) COMMENT '轉機類型',
fpriority INT  COMMENT '顯示優先級(0-不顯示，數字越大優先級越高)',
PRIMARY KEY (flightsid)
) DEFAULT CHARSET=UTF8;


CREATE TABLE t_scart_order
 (orderid INT AUTO_INCREMENT COMMENT '訂單編號',
client_email VARCHAR(30) COMMENT '用戶email',
client_id INT COMMENT '用戶id',
hotelid INT COMMENT '飯店類型id',
daysid INT COMMENT '旅遊天數id',
personid INT COMMENT '人數id',
flightsid_list VARCHAR(20) COMMENT '航班id組合',
hotel_append VARCHAR(100) COMMENT '飯店備注',
days_append VARCHAR(50) COMMENT '天數備注',
person_append VARCHAR(50) COMMENT '人數備注',
flights_append VARCHAR(100) COMMENT '航班備注',
other_append VARCHAR(300) COMMENT '其他備注',
order_status INT COMMENT '訂單狀態',
created_user VARCHAR(30) COMMENT '創建人',
created_time DATETIME COMMENT '創建時間',
modified_user VARCHAR(30) COMMENT '最後修改人',
modified_time DATETIME COMMENT '最後修改時間',
PRIMARY KEY (orderid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_scenic_order (scenic_order_id INT AUTO_INCREMENT COMMENT '選購項目id',
orderid INT COMMENT '訂單編號',
sid INT COMMENT '景點id',
tname VARCHAR(30) COMMENT '城市/區域名',
scenic VARCHAR(50) COMMENT '景點名稱',
sticket INT COMMENT '門票',
scode VARCHAR(12) COMMENT '景點代碼',
hotel_weights DOUBLE(3,2) COMMENT '飯店權重',
bus_weights DOUBLE(3,2) COMMENT '車資權重',
PRIMARY KEY (scenic_order_id),
FOREIGN KEY(orderid) REFERENCES t_scart_order(orderid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_order_feedback
 (order_feedback_id INT AUTO_INCREMENT COMMENT '行程反饋id',
orderid INT COMMENT '訂單編號',
feedback_name VARCHAR(50) COMMENT '反饋行程名稱',
feedback_pdf VARCHAR(100) COMMENT '反饋行程鏈接',
add_append VARCHAR(300) COMMENT '行程補充備註',
created_user VARCHAR(30) COMMENT '創建人',
created_time DATETIME COMMENT '創建時間',
modified_user VARCHAR(30) COMMENT '最後修改人',
modified_time DATETIME COMMENT '最後修改時間',
PRIMARY KEY (order_feedback_id),
FOREIGN KEY(orderid) REFERENCES t_scart_order(orderid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_order_payment
(payment_id INT AUTO_INCREMENT COMMENT '訂單支付id',
orderid INT COMMENT '訂單編號',
payable_amount INT COMMENT '應付訂金',
payable_time Date COMMENT '應付訂金創建時間',
payment_amount INT COMMENT '實付金額',
payment_time Date COMMENT '付款時間',
payment_method varchar(30) COMMENT '付款方式',
financial_receipt varchar(20) COMMENT '財務收據流水號',
reference_info varchar(50) COMMENT '備註資訊',
PRIMARY KEY (payment_id),
FOREIGN KEY(orderid) REFERENCES t_scart_order(orderid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_order_status
 (order_status_id INT AUTO_INCREMENT COMMENT '訂單狀態id',
order_status INT COMMENT '訂單狀態',
order_status_desc VARCHAR(30) COMMENT '訂單狀態描述',
PRIMARY KEY (order_status_id)
) DEFAULT CHARSET=UTF8;

INSERT INTO t_order_status
(order_status, order_status_desc) values
(0, '已取消'), 
(1, '已生成, 待付款'), 
(2, '已付款, 請等待行程反饋'),
(3, '訂單已完成');

CREATE TABLE t_order_addappend
 (order_addappend_id INT AUTO_INCREMENT COMMENT '訂單備註id',
orderid INT COMMENT '訂單編號',
add_append VARCHAR(300) COMMENT '行程補充備註',
created_user VARCHAR(20) COMMENT '創建人',
created_time DATETIME COMMENT '創建時間',
modified_user VARCHAR(20) COMMENT '最後修改人',
modified_time DATETIME COMMENT '最後修改時間',
PRIMARY KEY (order_addappend_id)
) DEFAULT CHARSET=UTF8;


CREATE TABLE t_calculate_temp (ctid INT AUTO_INCREMENT COMMENT '計算器id',
scode VARCHAR(12) COMMENT '景點代碼',
stime VARCHAR(20) COMMENT '參觀時間',
hotel_weights DOUBLE(3,2) COMMENT '飯店權重',
bus_weights DOUBLE(3,2) COMMENT '車資權重',
sdays INT COMMENT '停留天數',
PRIMARY KEY (ctid)
) DEFAULT CHARSET=UTF8;


CREATE TABLE t_route
 (routeid INT AUTO_INCREMENT COMMENT '經典行程id',
caid INT COMMENT '景點類型id',
route_code CHAR(5) COMMENT '行程代碼',
route_name VARCHAR(50) COMMENT '行程名稱',
rpriority INT COMMENT '顯示優先級(0-不顯示，數字越大優先級越高)',
route_image VARCHAR(40) COMMENT '代表圖片',
route_pdf VARCHAR(100) COMMENT '行程明細鏈接',
PRIMARY KEY (routeid)
) DEFAULT CHARSET=UTF8;


CREATE TABLE t_contact_message
 (message_id INT AUTO_INCREMENT COMMENT '信息id',
client_id INT COMMENT '用戶id',
client_nickname VARCHAR(20) COMMENT '用戶名',
client_email VARCHAR(50) COMMENT '用戶email或電話',
message_subject VARCHAR(100) COMMENT '主旨',
message_detail VARCHAR(300) COMMENT '信息內容',
message_status INT COMMENT '信息狀態(0-新信息，1-已回覆，2-已處理,無需回覆，3-資料錯誤，無法回覆)',
message_feedback VARCHAR(200) COMMENT '回覆資料',
created_user VARCHAR(20) COMMENT '創建人',
created_time DATETIME COMMENT '創建時間',
modified_user VARCHAR(20) COMMENT '最後修改人',
modified_time DATETIME COMMENT '最後修改時間',
PRIMARY KEY (message_id)
) DEFAULT CHARSET=UTF8;


CREATE TABLE t_about_faq
 (about_faq_id INT AUTO_INCREMENT COMMENT '常見問題id',
faq_code VARCHAR(10) COMMENT '問題代碼',
about_question VARCHAR(200) COMMENT '問題',
about_answer VARCHAR(300) COMMENT '解答',
faq_priority INT COMMENT '問題優先級(0-不顯示，數字越大優先級越高)',
PRIMARY KEY (about_faq_id)
) DEFAULT CHARSET=UTF8;


CREATE TABLE t_forgot_password
 (verify_id INT AUTO_INCREMENT COMMENT '驗證碼id',
client_email VARCHAR(30) COMMENT '電子郵箱',
validata_code CHAR(6) COMMENT '驗證碼',
expired_time DATETIME COMMENT '有效期限',
PRIMARY KEY (verify_id)
) DEFAULT CHARSET=UTF8;