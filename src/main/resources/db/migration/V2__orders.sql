create table order_location
(
    id        bigint auto_increment
        primary key,
    date      datetime(6) null,
    latitude  double      null,
    longitude double      null
);

create table orders
(
    id                   bigint auto_increment
        primary key,
    oeprator_id          bigint not null,
    end_order_location   bigint null,
    start_order_location bigint null,
    constraint FK_end_order_id
        foreign key (end_order_location) references order_location (id),
    constraint FK_start_order_id
        foreign key (start_order_location) references order_location (id)
);

create table orders_assists
(
    order_id   bigint not null,
    assists_id bigint not null,
    constraint FK_orders_id_orders_assist
        foreign key (order_id) references orders (id),
    constraint FK_assist_id_orders_assist
        foreign key (assists_id) references assistances (id)
);

