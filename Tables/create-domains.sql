------------------------------------------
-- DOMAINS AND OTHER CONSTRAINTS (Other than foreign key) -- DOMAINS AND OTHER CONSTRAINTS (Other than foreign key) -- DOMAINS AND OTHER CONSTRAINTS (Other than foreign key)-- DOMAINS AND OTHER CONSTRAINTS (Other than foreign key)

-- HORSE_SEX DOMAIN
ALTER TABLE [dbo].[HORSE]
ADD CONSTRAINT [HORSE_SEX_DOMAIN]
CHECK(
	sex IN ( 'stallion','mare', 'gelding', 'colt', 'filly', 'foal', 'yearling', 'rig')
)
GO
--TITLE DOMAIN
ALTER TABLE [dbo].[OWNER] 
ADD CONSTRAINT [OWNER_TITLE_DOMAIN]
CHECK(
	title IN ( 'Mr.','Dr.','Miss', 'Mrs')
)
GO
--USER_ROLE DOMAIN
ALTER TABLE [dbo].[SYSTEM_USER] 
ADD CONSTRAINT [USER_ROLE_DOMAIN]
CHECK(
	role IN ( 'R1','SA')
)
GO
--ID Constraints
-- ID for TRAINER
ALTER TABLE [dbo].[TRAINER]
ADD CONSTRAINT [ID_CONSTR_TRAINER] CHECK ((LEN([id])=6) AND ([id] >= 0 AND [id] <= 999999))
GO
-- ID for JOCKEY
ALTER TABLE [dbo].[JOCKEY]
ADD CONSTRAINT [ID_CONSTR_JOCKEY] CHECK ((LEN([id])=6) AND ([id] >= 0 AND [id] <= 999999))
GO
-- ID for BREEDER
ALTER TABLE [dbo].[BREEDER]
ADD CONSTRAINT [ID_CONSTR_BREEDER] CHECK ((LEN([id])=6) AND ([id] >= 0 AND [id] <= 999999))
GO
-- ID for OWNER
ALTER TABLE [dbo].[OWNER]
ADD CONSTRAINT [ID_CONSTR_OWNER] CHECK ((LEN([id])=6) AND ([id] >= 0 AND [id] <= 999999))
GO
-- ID for USER
ALTER TABLE [dbo].[SYSTEM_USER]
ADD CONSTRAINT [ID_CONSTR_SYSTEM_USER] CHECK ((LEN([id])=6) AND ([id] >= 0 AND [id] <= 999999))
GO
-- PRICE_1 for RACE
ALTER TABLE [dbo].[RACE]
ADD CONSTRAINT [PRIZE1_CONSTR_RACE] CHECK([prize_1] > [prize_2])
GO
-- PRICE_2 for RACE
ALTER TABLE [dbo].[RACE]
ADD CONSTRAINT [PRIZE2_CONSTR_RACE] CHECK([prize_2] > [prize_3])
GO