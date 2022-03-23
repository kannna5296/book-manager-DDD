CREATE TABLE [dbo].[user](
    [id] [bigint] NOT NULL,
    [email] [nvarchar](256) UNIQUE NOT NULL,
    [password] [nvarchar](128) NOT NULL,
    [name] [nvarchar](32) NOT NULL,
    [role_type] [nvarchar](10) NOT NULL,
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
    [title] [nvarchar](128) UNIQUE NOT NULL,
    [author] [nvarchar](32) NOT NULL,
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