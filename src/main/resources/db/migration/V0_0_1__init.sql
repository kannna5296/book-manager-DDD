CREATE TABLE [dbo].[user](
    [id] [bigint] NOT NULL,
    [email] [varchar](256) UNIQUE NOT NULL,
    [password] [varchar](128) NOT NULL,
    [name] [varchar](32) NOT NULL,
    [role_type] [varchar](10) NOT NULL,
    PRIMARY KEY CLUSTERED([id] ASC) WITH(
        PAD_INDEX = OFF,
        STATISTICS_NORECOMPUTE = OFF,
        IGNORE_DUP_KEY = OFF,
        ALLOW_ROW_LOCKS =
    ON,
        ALLOW_PAGE_LOCKS =
    ON
    )
ON  [PRIMARY]
)
ON  [PRIMARY]

CREATE TABLE [dbo].[book](
    [id] [bigint] NOT NULL,
    [title] [varchar](128) UNIQUE NOT NULL,
    [author] [varchar](32) NOT NULL,
    [release_date] [date] NOT NULL,
    PRIMARY KEY CLUSTERED([id] ASC) WITH(
        PAD_INDEX = OFF,
        STATISTICS_NORECOMPUTE = OFF,
        IGNORE_DUP_KEY = OFF,
        ALLOW_ROW_LOCKS =
    ON,
        ALLOW_PAGE_LOCKS =
    ON
    )
ON  [PRIMARY]
)
ON  [PRIMARY]

CREATE TABLE [dbo].[rental](
    [book_id] [bigint] NOT NULL,
    [user_id] [bigint] NOT NULL,
    [rental_datetime] [datetime2](2) NOT NULL,
    [return_deadline] [datetime2](2) NOT NULL,
    PRIMARY KEY CLUSTERED([book_id] ASC) WITH(
        PAD_INDEX = OFF,
        STATISTICS_NORECOMPUTE = OFF,
        IGNORE_DUP_KEY = OFF,
        ALLOW_ROW_LOCKS =
    ON,
        ALLOW_PAGE_LOCKS =
    ON
    )
ON  [PRIMARY]
)
ON  [PRIMARY]