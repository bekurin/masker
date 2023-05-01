package converter

import annotation.Ensure
import constant.ProcessType
import util.EnsureUtils
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
@Ensure(ProcessType.PASSWORD)
class PasswordConverter : AttributeConverter<String, String> {
    override fun convertToDatabaseColumn(attribute: String?): String? {
        return attribute
    }

    override fun convertToEntityAttribute(dbData: String?): String? {
        if (dbData == null) {
            return null
        }
        val ensure = javaClass.getAnnotation(Ensure::class.java)
        return EnsureUtils.ensure(dbData, ensure.processType)
    }

}
