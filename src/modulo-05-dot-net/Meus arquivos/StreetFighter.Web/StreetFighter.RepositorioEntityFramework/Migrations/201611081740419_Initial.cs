namespace StreetFighter.RepositorioEntityFramework.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Personagem",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Imagem = c.String(),
                        Nome = c.String(),
                        DataNascimento = c.DateTime(nullable: false),
                        Altura = c.Int(nullable: false),
                        Peso = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Origem = c.String(),
                        GolpesEspeciais = c.String(),
                        PersonagemOculto = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Personagem");
        }
    }
}
