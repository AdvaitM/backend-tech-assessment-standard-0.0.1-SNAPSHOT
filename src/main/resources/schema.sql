/**
 * Creates the buyer table, the buyer table has an id which is auto-generated , a description and an email id
 */
create table buyer (id bigint auto_increment primary key, description varchar(255) , email_id varchar(100));

/**
 * Creates the seller table, the buyer table has an id which is auto-generated , a description and an email id
 */
create table seller (id bigint auto_increment primary key, description varchar(255) , email_id varchar(100));

/**
 * Creates the project table, the project table has an id which is auto-generated , the budget for the project, the closing date time for the bidding, and the id of the seller.
 * The seller's id acts as a foreign key so that users are not allowed to add projects without registering as a seller first. 
 */
create table project (id bigint auto_increment primary key, budget double, closing datetime, description varchar(255), seller_id bigint, foreign key (seller_id) references seller(id));

/**
 * Creates the bid table, the bid table has an id which is auto-generated , the budget for the project, the bid placed date time, and the id of the project to place the bid for and the id of the buyer placing the bid.
 * The buyer's id acts as a foreign key so that users are not allowed to add buds without registering as a buyer first. The project id is also a foreign key so that buyers can't place bids for non-existent projects 
 */
create table bid (id bigint auto_increment primary key, bid_amount double, bid_placed_date_time datetime, buyer_id bigint, project_id bigint, foreign key (project_id) references project(id), foreign key (buyer_id) references buyer(id));