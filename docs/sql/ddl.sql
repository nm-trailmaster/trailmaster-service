create sequence hibernate_sequence start with 1 increment by 1;
create table campsite
(
    campsite_id bigint        not null,
    comment     varchar(5000) not null,
    created     timestamp     not null,
    latitude    double        not null,
    longitude   double        not null,
    rating      integer       not null,
    updated     timestamp     not null,
    primary key (campsite_id)
);
create table photo
(
    photo_id    bigint       not null,
    created     timestamp    not null,
    filepath    varchar(255) not null,
    updated     timestamp    not null,
    campsite_id bigint,
    trail_id    bigint,
    primary key (photo_id)
);
create table trail
(
    trail_id  bigint        not null,
    comment   varchar(5000) not null,
    created   timestamp     not null,
    latitude  double        not null,
    longitude double        not null,
    rating    integer       not null,
    updated   timestamp     not null,
    primary key (trail_id)
);
alter table photo
    add constraint FK4768dx8a3v0raltb4cxkb0nx7 foreign key (campsite_id) references campsite;
alter table photo
    add constraint FKfsgrsw612jk5mgbeeot5wxevo foreign key (trail_id) references trail;
create sequence hibernate_sequence start with 1 increment by 1;
create table campsite
(
    campsite_id bigint        not null,
    comment     varchar(5000) not null,
    created     timestamp     not null,
    latitude    double        not null,
    longitude   double        not null,
    rating      integer       not null,
    updated     timestamp     not null,
    primary key (campsite_id)
);
create table photo
(
    photo_id    bigint       not null,
    created     timestamp    not null,
    filepath    varchar(255) not null,
    updated     timestamp    not null,
    campsite_id bigint,
    trail_id    bigint,
    primary key (photo_id)
);
create table trail
(
    trail_id  bigint        not null,
    comment   varchar(5000) not null,
    created   timestamp     not null,
    latitude  double        not null,
    longitude double        not null,
    rating    integer       not null,
    updated   timestamp     not null,
    primary key (trail_id)
);
alter table photo
    add constraint FK4768dx8a3v0raltb4cxkb0nx7 foreign key (campsite_id) references campsite;
alter table photo
    add constraint FKfsgrsw612jk5mgbeeot5wxevo foreign key (trail_id) references trail;
