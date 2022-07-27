import io.circe.Decoder
import io.circe.generic.auto._
import io.circe.generic.semiauto.deriveDecoder
import io.circe.parser.decode
import io.circe.syntax._

import java.io._
import scala.io.Source
import scala.util.Using

case class Name(common: String)

case class Country(name: Name, region: String, capital: List[String], area: Double)

case class TopContryAfrica(name: String, capital: String, area: Double)

object TopContryAfrica {
  def createDto(country: Country): TopContryAfrica =
    TopContryAfrica(
      name = country.name.common,
      capital = country.capital.head,
      area = country.area
    )

}

object ParserJsonCountries extends App {
  val name: Decoder[Name] = deriveDecoder[Name]
  val country: Decoder[Country] = deriveDecoder[Country]

  val pathFileJson = "data/countries.json"

  val countryTopArea = Using(Source.fromFile(pathFileJson)) { file =>
    decode[List[Country]](file.mkString) match {
      case Right(value) => value
        .filter(_.region == "Africa")
        .sortBy(_.area)
        .reverse
        .slice(0, 10)
        .map(TopContryAfrica.createDto)
        .asJson
      case Left(ex) => println(s"Ooops some error here ${ex}")
    }
  }

  var path = "./"
  if (args.length != 0) path = args(0)

  val resultFile = new PrintWriter(new File(path + "/result.json"))
  resultFile.write(countryTopArea.getOrElse().toString)
  resultFile.close()

}

