
package client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStudentsByCourseResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStudentsByCourseResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="students" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="student" type="{http://api.soa.agh.edu.pl/}student" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStudentsByCourseResponse", propOrder = {
    "students"
})
public class GetStudentsByCourseResponse {

    protected GetStudentsByCourseResponse.Students students;

    /**
     * Gets the value of the students property.
     * 
     * @return
     *     possible object is
     *     {@link GetStudentsByCourseResponse.Students }
     *     
     */
    public GetStudentsByCourseResponse.Students getStudents() {
        return students;
    }

    /**
     * Sets the value of the students property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetStudentsByCourseResponse.Students }
     *     
     */
    public void setStudents(GetStudentsByCourseResponse.Students value) {
        this.students = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="student" type="{http://api.soa.agh.edu.pl/}student" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "student"
    })
    public static class Students {

        protected List<Student> student;

        /**
         * Gets the value of the student property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the student property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStudent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Student }
         * 
         * 
         */
        public List<Student> getStudent() {
            if (student == null) {
                student = new ArrayList<Student>();
            }
            return this.student;
        }

    }

}
