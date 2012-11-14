<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Upslp extends CI_Controller {
	public function index(){

		$matricula = $this->uri->segment(3);

		$this->load->database();
		$query = $this->db->get_where('VINFGRALALUMNO', array("MATRICULA"=>$matricula));
		echo json_encode(end($query->result()));
	}
	public function plan_estudio(){

		$carrera = $this->uri->segment(3);

		$this->load->database();
		$materias = array();
		for($x = 1; $x < 10; $x++){
			$query = $this->db->select('MATERIA, SERIACION, SEMESTRE');
			$query = $this->db->get_where( 'VPLANESTUDIO', array( "CVEPLAN" => $carrera, "SEMESTRE" => $x ) );
			$semestre = array( $x => $query->result() );
			array_push( $materias, $semestre );
		}
		echo json_encode( $materias );
	}
	public function plan_estudio2(){

		$carrera = $this->uri->segment(3);

		$this->load->database();
		$query = $this->db->select('MATERIA, SEMESTRE');
		$this->db->order_by("SEMESTRE");
		$query = $this->db->get_where( 'VPLANESTUDIO', array( "CVEPLAN" => $carrera ) );

		echo json_encode( $query->result() );
	}
	public function plan_estudio_optativo(){

		$carrera = $this->uri->segment(3);

		$this->load->database();
		$query = $this->db->select('MATOPTATIVA, SEMESTRE');
		$this->db->order_by("SEMESTRE");
		$query = $this->db->get_where( 'VPLANESTUDIOOPT', array( "CVEPLAN" => $carrera ) );

		echo json_encode( $query->result() );
	}
	public function plan_estudio_cursado(){

		$matricula = $this->uri->segment(3);


		$this->load->database();
		$this->db->select('MATERIA, MATSEM');
		$this->db->order_by("MATSEM");
		$this->db->distinct();
		$query = $this->db->get_where( 'VCALIFALUFINALES', array( "MATRICULA" => $matricula ) );

		echo json_encode( $query->result() );
	}
	public function plan_estudio_count(){

		$carrera = $this->uri->segment(3);

		$this->load->database();
		$this->db->select( "COUNT(MATERIA) as total_materias" );
		$query = $this->db->get_where( 'VPLANESTUDIO', array( "CVEPLAN" => $carrera ) );
		$result = $query->result();
		echo json_encode( $query->result() );

	}

	public function plan_estudio_opt_count(){

		$carrera = $this->uri->segment(3);

		$this->load->database();
		$this->db->select( "COUNT(MATERIA) as total_materias" );
		$query = $this->db->get_where( 'VPLANESTUDIOOPT', array( "CVEPLAN" => $carrera ) );
		echo json_encode( $query->result() );

	}

	public function materias_cursadas_count(){
		$matricula = $this->uri->segment(3);

		$this->load->database();
		$this->db->select( 'COUNT(MATERIA) as total_materias' );
		$this->db->distinct();
		$query = $this->db->get_where( 'VCALIFALUFINALES', array( 'MATRICULA' => $matricula ) );
		echo "<pre>";
			print_r($query->result());
		echo "</pre>";
	}
	public function materias_count(){
		$carrera = $this->uri->segment(3);

		$this->load->database();
		$this->db->select( "COUNT(MATERIA) as total_materias" );
		$query = $this->db->get_where( 'VPLANESTUDIOOPT', array( "CVEPLAN" => $carrera ) );
		$optativas_array = $query->result();
		$optativas = $optativas_array[0]->TOTAL_MATERIAS;


		$this->db->select( "COUNT(MATERIA) as total_materias" );
		$query = $this->db->get_where( 'VPLANESTUDIO', array( "CVEPLAN" => $carrera ) );
		$result = $query->result();

		$total = $optativas_array[0]->TOTAL_MATERIAS + $result[0]->TOTAL_MATERIAS;

		echo $total;

	}
	public function horario(){

		$matricula = $this->uri->segment(3);

		$this->load->database();

		$query = $this->db->get_where('VINFGRALALUMNO', array("MATRICULA"=>$matricula));
		$resultados_array = $query->result();
		$ultimo = end($resultados_array);
		$query = $this->db->get_where('VHORARIOALU', array("MATRICULA" => $matricula, "PERIODO" => $ultimo->PERIODO));
		echo json_encode( $query->result() );
	}
	public function faltas_primer_parcial(){
		$matricula = $this->uri->segment(3);

		$this->load->database();

		$query = $this->db->get_where('VINFGRALALUMNO', array("MATRICULA"=>$matricula));
		$resultados_array = $query->result();
		$ultimo = end($resultados_array);
		$this->db->select('NOMMATERIA, INAS1');
		$query = $this->db->get_where('VCALIFINASISTALU', array("MATRICULA" => $matricula, "PERIODO" => $ultimo->PERIODO));
	
		
		echo json_encode( $query->result() );
	}
	public function faltas_segundo_parcial(){
		$matricula = $this->uri->segment(3);

		$this->load->database();

		$query = $this->db->get_where('VINFGRALALUMNO', array("MATRICULA"=>$matricula));
		$resultados_array = $query->result();
		$ultimo = end($resultados_array);
		$this->db->select('NOMMATERIA, INAS2');
		$query = $this->db->get_where('VCALIFINASISTALU', array("MATRICULA" => $matricula, "PERIODO" => $ultimo->PERIODO));
	
		
		echo json_encode( $query->result() );
	}
	public function faltas_tercer_parcial(){
		$matricula = $this->uri->segment(3);

		$this->load->database();

		$query = $this->db->get_where('VINFGRALALUMNO', array("MATRICULA"=>$matricula));
		$resultados_array = $query->result();
		$ultimo = end($resultados_array);
		$this->db->select('NOMMATERIA, INAS3');
		$query = $this->db->get_where('VCALIFINASISTALU', array("MATRICULA" => $matricula, "PERIODO" => $ultimo->PERIODO));
	
		
		echo json_encode( $query->result() );
	}
	public function faltas(){
		$matricula = $this->uri->segment(3);

		$this->load->database();

		$query = $this->db->get_where('VINFGRALALUMNO', array("MATRICULA"=>$matricula));
		$resultados_array = $query->result();
		$ultimo = end($resultados_array);
		$this->db->select('NOMMATERIA, INAS1, INAS2, INAS3');
		$query = $this->db->get_where('VCALIFINASISTALU', array("MATRICULA" => $matricula, "PERIODO" => $ultimo->PERIODO));
	
		
		echo json_encode( $query->result() );
	}
	public function calificaciones(){
		$matricula = $this->uri->segment(3);
		$this->load->database();

		$query = $this->db->get_where('VINFGRALALUMNO', array("MATRICULA"=>$matricula));
		$resultados_array = $query->result();
		$ultimo = end($resultados_array);

		$this->db->select('NOMMATERIA, EX1P, EX2P, EX3P, EXFINAL, CALFINAL, EXTRA, REGUL');
		$query = $this->db->get_where("VCALIFINASISTALU", array("MATRICULA" => $matricula, "PERIODO" => $ultimo->PERIODO));
		
		
		echo json_encode( $query->result() );

	}
}